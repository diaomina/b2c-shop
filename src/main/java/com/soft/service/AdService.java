package com.soft.service;

import com.soft.model.Ad;

import java.util.List;

/**
 * @ClassName AdService
 * @Description 广告的业务接口
 * @Author ljy
 * @Date 2020/1/11 19:33
 * @Version 1.0
 **/
public interface AdService {

    /**
     * @Description 查询所有广告
     * @Param []
     * @Return java.util.List<com.soft.model.Ad>
     * @Author ljy
     * @Date 2020/1/11 19:34
     **/
    List<Ad> findAllListAd();

    /**
     * @Description 根据 ad_id 查询广告
     * @Param [adId]
     * @Return com.soft.model.Ad
     * @Author ljy
     * @Date 2020/1/11 19:34
     **/
    Ad loadByAdId(Integer adId);

    /**
     * @Description 添加广告
     * @Param [ad]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:35
     **/
    int createAd(Ad ad);

    /**
     * @Description 删除广告
     * @Param [adId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:36
     **/
    int delAd(Integer adId);

    /**
     * @Description 更新广告
     * @Param [ad]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:36
     **/
    int updateAd(Ad ad);

    /**
     * @Description 批量关闭
     * @Param [list]
     * @Return int
     * @Author ljy
     * @Date 2020/2/11 21:26
     **/
    int stopBatchAd(List<Integer> list);
}
