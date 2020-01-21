package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.model.Admin;
import com.soft.model.Goods;
import com.soft.service.GoodsCategoryService;
import com.soft.service.GoodsService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName GoodsAction
 * @Description 商品控制器
 * @Author ljy
 * @Date 2020/1/16 20:11
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goodsAction")
public class GoodsAction {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * @Description 跳转到商品管理主页
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/18 23:12
     **/
    @RequestMapping("/goGoodsMain")
    public ModelAndView goGoodsMain(){
        return new ModelAndView("admin/goods_manager/goods_main", "goodsList", goodsService.findAllListGoods());
    }


    /**
     * @Description 跳转到商品添加界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/21 22:38
     **/
    @RequestMapping("/goGoodsAdd")
    public ModelAndView goGoodsAdd(){
        return new ModelAndView("admin/goods_manager/goods_add","goodsCategoryList", goodsCategoryService.findAllListGoodsCategory());
    }


    /**
     * @Description 商品添加
     * @Param [goods, goodsImage, request]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/21 23:12
     **/
    @RequestMapping("/doGoodsAdd")
    @ResponseBody
    public JSONObject doGoodsAdd(Goods goods, MultipartFile goodsImage, HttpServletRequest request) throws IOException {
        JSONObject jsonObject = new JSONObject();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(goodsImage.getOriginalFilename());
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("/upload");
        //以绝对路径保存重名命后的图片
        goodsImage.transferTo(new File(url+"/"+name + "." + ext));
        //把图片存储路径保存到数据库
        goods.setImage("upload/"+name + "." + ext);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        goods.setAdminId(admin.getAdminId());
        // 判断添加是否成功
        if(goodsService.createGoods(goods) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }

}
