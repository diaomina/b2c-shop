package com.soft.test;

import com.soft.b2cshop.B2cShopApplication;
import com.soft.model.Goods;
import com.soft.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description GoodsService测试类
 * @Author ljy
 * @Date 2020/1/27 14:11
 **/
@SpringBootTest(classes = B2cShopApplication.class)
@RunWith(SpringRunner.class)
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void findAllListGoods() {
    }

    @Test
    public void findListByGoodsName() {
    }

    @Test
    public void loadByGoodsId() {
    }

    @Test
    public void createGoods() {
        Goods goods = new Goods();
        goods.setGoodsName("华为Nova5Pro");
        goods.setPrice(599000);
        goods.setQuantity(999);
        goods.setImage("upload/1.jpg");
        goods.setSimpleDescribe("128g 金色");
        goods.setAdminId(1);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        int recordNumber = goodsService.createGoods(goods);
        System.out.println(recordNumber);
    }

    @Test
    public void delGoods() {
    }

    @Test
    public void updateGoods() {
    }
}