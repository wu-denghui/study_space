package com.goodhealth.framework.entity;



import java.util.Date;


/**
 * @Author WuDengHui
 * @Description
 * @Date 2019/4/2016:59
 */
public abstract class AbstractDO {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 生成时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
    /**
     * 备用
     */
    private String feature;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Date gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
