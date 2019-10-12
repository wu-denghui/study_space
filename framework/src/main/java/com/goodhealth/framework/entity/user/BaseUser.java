package com.goodhealth.framework.entity.user;

import java.util.Date;

/**
 * 用户基础信息
 */
public class BaseUser implements IUser {

    /**
     * id
     */
    protected String id;

    /**
     * 用户名
     */
    protected String userName;

    /**
     * 密码
     */
    protected String password;

    /**
     * 电子邮件
     */
    protected String email;

    /**
     * 姓名
     */
    protected String realName;

    /**
     * 昵称
     */
    protected String nickname;

    /**
     * 性别
     */
    protected String gender;

    /**
     *  手机
     */
    protected String mobile;

    /**
     * 固定电话
     */
    protected String telephone;

    /**
     * 部门编号
     */
    protected String deptId;

    /**
     * 审核状态(2，已审核)
     */
    protected int status;

    /**
     * 客户编码(对应CRM系统的linkmanId)
     */
    protected String cusCode;

    /**
     * 用户头像
     */
    protected String headimgurl;


    /**
     * 用户类型
     * 0 只绑定邮箱的用户
     * 1 手机注册用户
     * 2 手机和邮箱均验证用户,
     * 3 微信注册用户,
     * 4 小程序注册用户，
     * 5 支付宝服务窗
     * 6 微信网页扫描注册用户
     */
    protected int userType;

    /**
     * 冻结标记
     */
    protected String frozenStatus;

    /**
     * 冻结开始时间
     */
    protected Date frozenBeginDate;

    /**
     * 冻结开始时间
     */
    protected Date frozenEndDate;

    /**
     * 证件类型  身份证：IDCARD；
     * 军人证：ARMYMANCARD；
     * 护照： PASSPORT；
     * 外国人永久居留证 ： FOREIGNCRAD；
     * 武警证： POLICECARD；
     * 学生证：STUDENTCARD；
     * 士兵证：SOLDIERCARD
     */
    protected String cardType;

    /**
     * 证件号码
     */
    protected String cardId;

    /**
     * 省
     */
    protected String province;

    /**
     * 市
     */
    protected String city;

    /**
     * 区县
     */
    protected String county;

    /**
     * 地址
     */
    protected String address;

    /**
     * 地址备注
     */
    protected String remarkAddress;

    /**
     * 注册ip
     */
    protected String registIp;

    /**
     * 注册来源
     */
    protected String sysCode;

    /**
     * 最后更新时间
     */
    protected Date lastUpdateTime;


    /**
     * 上次登录时间
     */
    protected Date lastLoginTime;

    /**
     * 注册时间
     */
    protected Date regiterTime;

    /**
     * unionId
     */
    protected String unionId;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getCusCode() {
        return cusCode;
    }

    @Override
    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getFrozenStatus() {
        return frozenStatus;
    }

    public void setFrozenStatus(String frozenStatus) {
        this.frozenStatus = frozenStatus;
    }

    public Date getFrozenBeginDate() {
        return frozenBeginDate;
    }

    public void setFrozenBeginDate(Date frozenBeginDate) {
        this.frozenBeginDate = frozenBeginDate;
    }

    public Date getFrozenEndDate() {
        return frozenEndDate;
    }

    public void setFrozenEndDate(Date frozenEndDate) {
        this.frozenEndDate = frozenEndDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarkAddress() {
        return remarkAddress;
    }

    public void setRemarkAddress(String remarkAddress) {
        this.remarkAddress = remarkAddress;
    }

    public String getRegistIp() {
        return registIp;
    }

    public void setRegistIp(String registIp) {
        this.registIp = registIp;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getRegiterTime() {
        return regiterTime;
    }

    public void setRegiterTime(Date regiterTime) {
        this.regiterTime = regiterTime;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
