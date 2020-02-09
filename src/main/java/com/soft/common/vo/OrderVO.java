package com.soft.common.vo;

import com.soft.model.User;
import com.soft.model.UserReceive;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderVO
 * @Description 订单显示
 * @Author ljy
 * @Date 2020/2/7 14:09
 * @Version 1.0
 **/
public class OrderVO implements Serializable {
    // 订单id
    private Integer orderId;
    // 订单号
    private String orderNumber;
    // 用户信息
    private User user;
    // 订单总金额
    private Integer totalAmount;
    // 地址信息
    private UserReceive userReceive;
    // 子订单VO列表
    private List<OrderChildVO> orderChildVOList;
    // 发货时间
    private Date sendTime;
    // 物流状态
    private Byte logisticsState;
    // 支付状态
    private Byte payState;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public UserReceive getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(UserReceive userReceive) {
        this.userReceive = userReceive;
    }

    public List<OrderChildVO> getOrderChildVOList() {
        return orderChildVOList;
    }

    public void setOrderChildVOList(List<OrderChildVO> orderChildVOList) {
        this.orderChildVOList = orderChildVOList;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getLogisticsState() {
        return logisticsState;
    }

    public void setLogisticsState(Byte logisticsState) {
        this.logisticsState = logisticsState;
    }

    public Byte getPayState() {
        return payState;
    }

    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
