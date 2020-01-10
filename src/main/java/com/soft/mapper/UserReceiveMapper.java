package com.soft.mapper;

import com.soft.model.UserReceive;
import com.soft.model.UserReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReceiveMapper {
    int countByExample(UserReceiveExample example);

    int deleteByExample(UserReceiveExample example);

    int deleteByPrimaryKey(Integer receiveId);

    int insert(UserReceive record);

    int insertSelective(UserReceive record);

    List<UserReceive> selectByExample(UserReceiveExample example);

    UserReceive selectByPrimaryKey(Integer receiveId);

    int updateByExampleSelective(@Param("record") UserReceive record, @Param("example") UserReceiveExample example);

    int updateByExample(@Param("record") UserReceive record, @Param("example") UserReceiveExample example);

    int updateByPrimaryKeySelective(UserReceive record);

    int updateByPrimaryKey(UserReceive record);
}