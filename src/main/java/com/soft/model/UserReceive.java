package com.soft.model;

import java.util.Date;

public class UserReceive {
    private Integer receiveId;

    private Integer userId;

    private String contact;

    private String tel;

    private String receiveProvince;

    private String receiveCity;

    private String receiveCounty;

    private String receiveAddress;

    private Date createTime;

    private Date updateTime;

    private Byte isdefault;

    private Byte delState;

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getReceiveProvince() {
        return receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince == null ? null : receiveProvince.trim();
    }

    public String getReceiveCity() {
        return receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity == null ? null : receiveCity.trim();
    }

    public String getReceiveCounty() {
        return receiveCounty;
    }

    public void setReceiveCounty(String receiveCounty) {
        this.receiveCounty = receiveCounty == null ? null : receiveCounty.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
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

    public Byte getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Byte isdefault) {
        this.isdefault = isdefault;
    }

    public Byte getDelState() {
        return delState;
    }

    public void setDelState(Byte delState) {
        this.delState = delState;
    }
}