package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.FileUtil;
import com.soft.common.vo.CategoryVO;
import com.soft.common.vo.GoodsVO;
import com.soft.model.Ad;
import com.soft.model.Admin;
import com.soft.model.Goods;
import com.soft.model.GoodsCategory;
import com.soft.service.AdService;
import com.soft.service.AdminService;
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
import javax.servlet.http.HttpSession;
import java.util.*;

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

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdService adService;

    /**
     * @Description 跳转到商品管理主页
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/18 23:12
     **/
    @RequestMapping("/goGoodsMain")
    public ModelAndView goGoodsMain(){
        List<Goods> goodsList = goodsService.findAllListGoods();
        List<GoodsVO> goodsVOList = new ArrayList<GoodsVO>();
        for(Goods goods : goodsList) {
            // 判断商品是否删除
            if (goods.getDelState() == 2) {
                // 封装GoodsVO
                GoodsVO goodsVO = new GoodsVO();
                goodsVO.setGoodsId(goods.getGoodsId());
                goodsVO.setGoodsName(goods.getGoodsName());
                goodsVO.setCategoryName(goodsCategoryService.loadByCategoryId(goods.getCategoryId()).getCategoryName());
                goodsVO.setImage(goods.getImage());
                goodsVO.setPrice(goods.getPrice());
                goodsVO.setQuantity(goods.getQuantity());
                goodsVO.setSimpleDescribe(goods.getSimpleDescribe());
                goodsVO.setIsMarketable(goods.getIsMarketable());
                goodsVO.setCreateTime(goods.getCreateTime());
                goodsVO.setUpdateTime(goods.getUpdateTime());
                goodsVO.setAdminName(adminService.loadByAdminId(goods.getAdminId()).getAdminName());
                goodsVOList.add(goodsVO);
            }
        }
        return new ModelAndView("admin/goods_manager/goods_main", "goodsVOList", goodsVOList);
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
    public JSONObject doGoodsAdd(Goods goods, MultipartFile goodsImage, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(goodsImage.getOriginalFilename());
        // 商品图片名称
        String goodsImageName = name + "." + ext;
        //设置图片上传路径
        String url = request.getSession().getServletContext().getRealPath("/static/upload");
        FileUtil.uploadFile(goodsImage.getBytes(), url, goodsImageName);

        //把图片存储路径保存到数据库
        goods.setImage("/static/upload/" + goodsImageName);
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


    /**
     * @Description 跳转到商品修改界面
     * @Param [goodsId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/27 17:18
     **/
    @RequestMapping("goGoodsEdit")
    public ModelAndView goGoodsEdit(Integer goodsId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/goods_manager/goods_edit");
        mv.addObject("goods", goodsService.loadByGoodsId(goodsId));
        mv.addObject("goodsCategoryList", goodsCategoryService.findAllListGoodsCategory());
        return mv;
    }


    /**
     * @Description 商品修改
     * @Param [goods, goodsImage, request]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/27 17:41
     **/
    @RequestMapping("/doGoodsEdit")
    @ResponseBody
    public JSONObject doGoodsEdit(Goods goods, MultipartFile goodsImage, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Goods dbGoods = goodsService.loadByGoodsId(goods.getGoodsId());
        // 判断是否更新了图片
        if(goodsImage != null) {
            //使用UUID给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            //获取文件的扩展名
            String ext = FilenameUtils.getExtension(goodsImage.getOriginalFilename());
            // 商品图片名称
            String goodsImageName = name + "." + ext;
            //设置图片上传路径
            String url = request.getSession().getServletContext().getRealPath("/static/upload");
            FileUtil.uploadFile(goodsImage.getBytes(), url, goodsImageName);
            dbGoods.setImage("/static/upload/" + goodsImageName);
        }

        dbGoods.setGoodsName(goods.getGoodsName());
        dbGoods.setCategoryId(goods.getCategoryId());
        dbGoods.setPrice(goods.getPrice());
        dbGoods.setQuantity(goods.getQuantity());
        dbGoods.setSimpleDescribe(goods.getSimpleDescribe());
        dbGoods.setUpdateTime(new Date());

        // 判断修改是否成功
        if(goodsService.updateGoods(dbGoods) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 商品删除
     * @Param [goodsId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/27 19:28
     **/
    @RequestMapping("/doGoodsDelete")
    @ResponseBody
    public JSONObject doGoodsDelete(Integer goodsId) {
        JSONObject jsonObject = new JSONObject();
        Goods goods = goodsService.loadByGoodsId(goodsId);
        goods.setDelState((byte) 1);
        // 判断删除是否成功
        if(goodsService.updateGoods(goods) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 商品 上架/下架
     * @Param [goodsId, state]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/27 18:57
     **/
    @RequestMapping("/doGoodsIsMarketable")
    @ResponseBody
    public JSONObject doGoodsIsMarketable(Integer goodsId, String state) {
        JSONObject jsonObject = new JSONObject();
        // 查询此商品
        Goods goods = goodsService.loadByGoodsId(goodsId);
        // 上架
        if("start".equals(state)) {
            goods.setIsMarketable((byte) 1);
        }
        // 下架
        if("stop".equals(state)) {
            goods.setIsMarketable((byte) 0);
        }
        // 判断更新结果
        if (goodsService.updateGoods(goods) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 商品 批量下架
     * @Param [goodsIds]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/27 19:55
     **/
    @RequestMapping("/doStopBatchGoods")
    @ResponseBody
    public JSONObject doStopBatchGoods(Integer[] goodsIds) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> list = new ArrayList<Integer>();
        for (Integer goodsId : goodsIds) {
            list.add(goodsId);
        }
        int recordNumber = goodsService.stopBatchGoods(list);
        if(recordNumber == list.size()){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
            jsonObject.put("number", list.size() - recordNumber);
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到商城首页
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/28 13:40
     **/
    @RequestMapping("/goIndex")
    public ModelAndView goIndex(HttpSession session) {
        // 所有种类
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.findAllListGoodsCategory();
        // 过滤已删除和未启用的种类
        Iterator<GoodsCategory> goodsCategoryListIterator = goodsCategoryList.iterator();
        while(goodsCategoryListIterator.hasNext()) {
            GoodsCategory goodsCategory = goodsCategoryListIterator.next();
            if(goodsCategory.getState() != 1) {
                goodsCategoryListIterator.remove();
            }
        }

        // 顶层种类
        List<GoodsCategory> parentCategoryList = new ArrayList<GoodsCategory>();
        // 获取所有顶层种类
        for(GoodsCategory g : goodsCategoryList) {
            // 判断是否为顶层种类
            if(g.getParentId() == 0) {
                // 是
                parentCategoryList.add(g);
            }
        }

        // 获取所有非顶层种类,此时goodsCategoryList内是所有非顶层种类
        goodsCategoryList.removeAll(parentCategoryList);


        List<CategoryVO> categoryVOList = new ArrayList<CategoryVO>();
        // 封装CategoryVO,将顶级种类与子种类匹配
        for(GoodsCategory pg : parentCategoryList) {
            CategoryVO categoryVO = new CategoryVO();
            List<GoodsCategory> categoryList = new ArrayList<GoodsCategory>();
            for(GoodsCategory cg : goodsCategoryList) {
                if(pg.getCategoryId() == cg.getParentId()) {
                    categoryList.add(cg);
                }
            }
            categoryVO.setParentCategoryId(pg.getCategoryId());
            categoryVO.setParentCategoryName(pg.getCategoryName());
            categoryVO.setCategoryList(categoryList);
            categoryVOList.add(categoryVO);
        }

        List<Goods> goodsList = new ArrayList<Goods>();
        for(Goods goods : goodsService.findAllListGoods()) {
            // 判断是否删除
            if (goods.getDelState() == 2) {
                // 判断是否上架
                if (goods.getIsMarketable() == 1) {
                    goodsList.add(goods);
                }
            }
        }

        // 获取广告
        List<Ad> adList = adService.findAllListAd();
        Iterator<Ad> iterator = adList.iterator();
        while(iterator.hasNext()) {
            Ad ad = iterator.next();
            // 去除已删除和关闭的广告
            if(ad.getDelState() == 1 || ad.getState() == 2) {
                iterator.remove();
            }
        }

        // 将商品种类导航信息保存到session，以供其他界面调用
        session.setAttribute("categoryVOList", categoryVOList);
        // 将广告保存到session，以供其他界面调用
        session.setAttribute("adList", adList);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/index");
        mv.addObject("goodsList", goodsList);
        mv.addObject("adList", adList);
        return mv;
    }



    /**
     * @Description 根据商品名称模糊查询商品
     * @Param [goodsName]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/13 0:02
     **/
    @RequestMapping("/doFindGoodsByGoodsName")
    public ModelAndView doFindGoodsByGoodsName(String goodsName) {
        List<Goods> goodsList = goodsService.findListByGoodsName(goodsName);
        Iterator<Goods> iterator = goodsList.iterator();
        // 过滤已删除和下架的商品
        while(iterator.hasNext()) {
            Goods goods = iterator.next();
            if(goods.getDelState() == 1 || goods.getIsMarketable() == 0){
                iterator.remove();
            }
        }
        return new ModelAndView("user/index", "goodsList", goodsList);
    }



    /**
     * @Description 根据商品种类id查询商品
     * @Param [state, categoryId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/13 0:29
     **/
    @RequestMapping("/doFindGoodsByGoodsCategory")
    public ModelAndView doFindGoodsByGoodsCategory(String state, Integer categoryId){
        List<Goods> goodsList = new ArrayList<Goods>();
        // 种类id是顶层种类
        if("parentCategory".equals(state)){
            // 1.获取该种类包含商品
            goodsList = goodsService.findListByCategoryId(categoryId);

            // 2.获取该种类的子种类
            List<GoodsCategory> goodsCategoryList = goodsCategoryService.findListGoodsCategoryByParentId(categoryId);
            // 过滤未启用和删除的种类
            Iterator<GoodsCategory> iterator = goodsCategoryList.iterator();
            while(iterator.hasNext()){
                GoodsCategory goodsCategory = iterator.next();
                if (goodsCategory.getState() != 1) {
                    iterator.remove();
                }
            }
            // 获取其子种类包含商品
            for(GoodsCategory goodsCategory : goodsCategoryList) {
                List<Goods> list = goodsService.findListByCategoryId(goodsCategory.getCategoryId());
                Iterator<Goods> iterator1 = list.iterator();
                // 过滤下架和已删除的商品
                while(iterator1.hasNext()){
                    Goods goods = iterator1.next();
                    if(goods.getDelState() == 1 || goods.getIsMarketable() == 0){
                        iterator1.remove();
                    }
                }
                // 去重：去除总的商品列表中包含的子种类的商品
                goodsList.removeAll(list);
                // 将子种类商品添加到总的商品列表中
                goodsList.addAll(list);
            }
        }

        // 种类id是非顶层种类
        if("category".equals(state)){
            goodsList = goodsService.findListByCategoryId(categoryId);
        }
        Iterator<Goods> iterator = goodsList.iterator();
        // 过滤已删除和下架的商品
        while(iterator.hasNext()) {
            Goods goods = iterator.next();
            if(goods.getDelState() == 1 || goods.getIsMarketable() == 0){
                iterator.remove();
            }
        }
        return new ModelAndView("user/index", "goodsList", goodsList);
    }


    /**
     * @Description 跳转到商品详情
     * @Param [goodsId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/28 23:46
     **/
    @RequestMapping("/goGoodsDetail")
    public ModelAndView goGoodsDetail(Integer goodsId, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/goods_detail");
        mv.addObject("goods", goodsService.loadByGoodsId(goodsId));
        return mv;
    }


}
