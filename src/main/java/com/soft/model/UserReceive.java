package com.soft.model;

import java.io.Serializable;
import java.util.Date;

public class UserReceive implements Serializable {
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

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserReceive{");
        sb.append("receiveId=").append(receiveId);
        sb.append(", userId=").append(userId);
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", receiveProvince='").append(receiveProvince).append('\'');
        sb.append(", receiveCity='").append(receiveCity).append('\'');
        sb.append(", receiveCounty='").append(receiveCounty).append('\'');
        sb.append(", receiveAddress='").append(receiveAddress).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isdefault=").append(isdefault);
        sb.append(", delState=").append(delState);
        sb.append('}');
        return sb.toString();
    }

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