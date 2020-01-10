package com.soft.mapper;

import com.soft.model.Ad;
import com.soft.model.AdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdMapper {
    int countByExample(AdExample example);

    int deleteByExample(AdExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    List<Ad> selectByExample(AdExample example);

    Ad selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}