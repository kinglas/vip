package com.yijun.vip.entity;

/**
 * Created by kinglas on 2017/8/2.
 */
public class VIPEntity {
    private String id;
    /*vip编号*/
    private String code;
    private String name;
    private Integer sex;
    private String gender;
    private int age;
    private String qq;
    private String email;
    private String address;
    /*邮政编码*/
    private String zip;
    /*备注*/
    private String remark;
    /*VIP等级*/
    private int rank;
    private String level;
    /*消费金额(分)*/
    private int amount;
    private String money;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public VIPEntity(String id, String code, String name, Integer sex, String gender, int age, String qq, String email, String address, String zip, String remark, int rank, String level, int amount, String money) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.gender = gender;
        this.age = age;
        this.qq = qq;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.remark = remark;
        this.rank = rank;
        this.level = level;
        this.amount = amount;
        this.money = money;
    }

    public VIPEntity() {
    }
}
