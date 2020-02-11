package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.FileUtil;
import com.soft.common.vo.AdVO;
import com.soft.model.Ad;
import com.soft.model.Admin;
import com.soft.model.Goods;
import com.soft.service.AdService;
import com.soft.service.AdminService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName AdAction
 * @Description 广告管理控制器
 * @Author ljy
 * @Date 2020/2/11 17:50
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adAction")
public class AdAction {

    @Autowired
    private AdService adService;

    @Autowired
    private AdminService adminService;


    /**
     * @Description 跳转到广告管理界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/11 17:52
     **/
    @RequestMapping("/goAdMain")
    public ModelAndView goAdMain() {
        List<Ad> adList = adService.findAllListAd();
        // 获取创建者名称，封装AdVO
        List<AdVO> adVOList = new ArrayList<>();
        for(Ad ad : adList) {
            // 过滤已删除的广告
            if (ad.getDelState() == 2) {
                AdVO adVO = new AdVO();
                adVO.setAdId(ad.getAdId());
                adVO.setImage(ad.getImage());
                adVO.setDescription(ad.getDescription());
                adVO.setUrl(ad.getUrl());
                adVO.setAdminName(adminService.loadByAdminId(ad.getAdminId()).getAdminName());
                adVO.setCreateTime(ad.getCreateTime());
                adVO.setUpdateTime(ad.getUpdateTime());
                adVO.setState(ad.getState());
                adVOList.add(adVO);
            }
        }
        return new ModelAndView("admin/ad_manager/ad_main", "adVOList", adVOList);
    }


    /**
     * @Description 跳转到广告添加界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/11 17:55
     **/
    @RequestMapping("/goAdAdd")
    public ModelAndView goAdAdd() {
        return new ModelAndView("admin/ad_manager/ad_add");
    }


    /**
     * @Description 广告添加
     * @Param [ad]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/11 17:56
     **/
    @RequestMapping("/doAdAdd")
    @ResponseBody
    public JSONObject doAdAdd(Ad ad, MultipartFile adImage, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(adImage.getOriginalFilename());
        // 商品图片名称
        String adImageName = name + "." + ext;
        //设置图片上传路径
        String url = session.getServletContext().getRealPath("/static/upload");
        // 上传图片
        FileUtil.uploadFile(adImage.getBytes(), url, adImageName);

        Admin admin = (Admin) session.getAttribute("admin");
        ad.setImage("/static/upload/" + adImageName);
        ad.setAdminId(admin.getAdminId());
        ad.setCreateTime(new Date());
        ad.setUpdateTime(new Date());
        // 判断添加是否成功
        if(adService.createAd(ad) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到广告编辑界面
     * @Param [adId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/11 17:57
     **/
    @RequestMapping("/goAdEdit")
    public ModelAndView goAdEdit(Integer adId) {
        return new ModelAndView("admin/ad_manager/ad_edit", "ad", adService.loadByAdId(adId));
    }


    /**
     * @Description 广告编辑
     * @Param [ad]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/11 17:56
     **/
    @RequestMapping("/doAdEdit")
    @ResponseBody
    public JSONObject doAdEdit(Ad ad) {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }


    /**
     * @Description 广告删除
     * @Param [adId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/11 19:38
     **/
    @RequestMapping("/doAdDelete")
    @ResponseBody
    public JSONObject doAdDelete(Integer adId) {
        JSONObject jsonObject = new JSONObject();
        Ad ad = adService.loadByAdId(adId);
        ad.setDelState((byte) 1);
        // 判断删除是否成功
        if(adService.updateAd(ad) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }



}
