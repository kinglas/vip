package com.yijun.vip.entity;

/**
 * Created by kinglas on 2017/8/2.
 */
public class VIPRankEntity {
    private int noId;
    private int discount;
    private String name;
    private int needAmount;
    private String remark;

    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(int needAmount) {
        this.needAmount = needAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
