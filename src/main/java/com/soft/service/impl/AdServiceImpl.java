package com.soft.service.impl;

import com.soft.mapper.AdMapper;
import com.soft.model.Ad;
import com.soft.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdServiceImpl
 * @Description AdService的实现类
 * @Author ljy
 * @Date 2020/1/11 19:39
 * @Version 1.0
 **/
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    /**
     * @Description 查询所有广告
     * @Param []
     * @Return java.util.List<com.soft.model.Ad>
     * @Author ljy
     * @Date 2020/1/11 19:34
     **/
    @Override
    public List<Ad> findAllListAd() {
        return adMapper.selectByExample(null);
    }

    /**
     * @param adId
     * @Description 根据 ad_id 查询广告
     * @Param [adId]
     * @Return com.soft.model.Ad
     * @Author ljy
     * @Date 2020/1/11 19:34
     */
    @Override
    public Ad loadByAdId(Integer adId) {
        return adMapper.selectByPrimaryKey(adId);
    }

    /**
     * @param ad
     * @Description 添加广告
     * @Param [ad]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:35
     */
    @Override
    public int createAd(Ad ad) {
        return adMapper.insertSelective(ad);
    }

    /**
     * @param adId
     * @Description 删除广告
     * @Param [adId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:36
     */
    @Override
    public int delAd(Integer adId) {
        Ad ad = adMapper.selectByPrimaryKey(adId);
        ad.setDelState((byte) 1);
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    /**
     * @param ad
     * @Description 更新广告
     * @Param [ad]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:36
     */
    @Override
    public int updateAd(Ad ad) {
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    /**
     * @param list
     * @Description 批量关闭
     * @Param [list]
     * @Return int
     * @Author ljy
     * @Date 2020/2/11 21:26
     */
    @Override
    public int stopBatchAd(List<Integer> list) {
        return adMapper.stopBatchByPrimaryKey(list);
    }
}
