package com.soft.mapper;

import com.soft.model.Order;
import com.soft.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * @Description 订单管理-批量删除
     * @Param [list]
     * @Return int
     * @Author ljy
     * @Date 2020/2/11 17:01
     **/
    int delBatchByPrimaryKey(@Param("list") List<Integer> list);
}