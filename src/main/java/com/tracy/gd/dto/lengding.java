package com.tracy.gd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by trcay on 2017/12/19.
 * 防止重复提交申请的dto
 */
public class lengding {

    private Integer laId;

    private Integer laUserId;

    private Integer laCptId;

    private String laReason;

    private Date laLendTime;

    private Date laReturnTime;

    private String laCommons;

    private String laLocation;

    private String laIsCheck;

    private String attribute1;  //用来存储是否已经处理 linsong.wei 2017-11-14 13:03:21

    private String attribute2;

    private String attribute3;

    @Transient
    private String cptName;

    @Transient
    private String userName;


    //尝试是否能查 用户身份，因为名字字段一样(attribute1)
    //成功，方法：在数据库查询的时候使用别名 2017-11-13 19:58:50
    @Transient
    private String userIdentity;


    @Transient
    private String eIsReturned;

    @Transient
    private Integer eDays;

    //费用
    @Transient
    private Integer eExpense;

    public String geteAttribute1() {
        return eAttribute1;
    }

    public void seteAttribute1(String eAttribute1) {
        this.eAttribute1 = eAttribute1;
    }

    //是否已经付款  2017-12-11 10:42:18
    @Transient
    private String eAttribute1;

    /*Update By: linsong.wei   2017-11-28 21:24:50
    把基本类型int换成Integer，否则会有默认值 0
*/
    //实际归还时间
    @Transient
    private Date eAreturnTime;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer geteExpense() {
        return eExpense;
    }

    public void seteExpense(int eExpense) {
        this.eExpense = eExpense;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date geteAreturnTime() {
        return eAreturnTime;
    }

    public void seteAreturnTime(Date eAreturnTime) {
        this.eAreturnTime = eAreturnTime;
    }


    public Integer geteDays() {
        return eDays;
    }

    public void seteDays(int eDays) {
        this.eDays = eDays;
    }

    public String geteIsReturned() {
        return eIsReturned;
    }

    public void seteIsReturned(String eIsReturned) {
        this.eIsReturned = eIsReturned;
    }

    public String getCptName() {
        return cptName;
    }

    public void setCptName(String cptName) {
        this.cptName = cptName;
    }

    public Integer getLaId() {
        return laId;
    }

    public void setLaId(Integer laId) {
        this.laId = laId;
    }

    public Integer getLaUserId() {
        return laUserId;
    }

    public void setLaUserId(Integer laUserId) {
        this.laUserId = laUserId;
    }

    public Integer getLaCptId() {
        return laCptId;
    }

    public void setLaCptId(Integer laCptId) {
        this.laCptId = laCptId;
    }

    public String getLaReason() {
        return laReason;
    }

    public void setLaReason(String laReason) {
        this.laReason = laReason == null ? null : laReason.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    //防止从mybatis查询出现unix long时间eg:1503912320000，而不是时间格式。 Update by :linsong.wei  2017-11-12 18:42:54
    public Date getLaLendTime() {
        return laLendTime;
    }

    public void setLaLendTime(Date laLendTime) {
        this.laLendTime = laLendTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getLaReturnTime() {
        return laReturnTime;
    }

    public void setLaReturnTime(Date laReturnTime) {
        this.laReturnTime = laReturnTime;
    }

    public String getLaCommons() {
        return laCommons;
    }

    public void setLaCommons(String laCommons) {
        this.laCommons = laCommons == null ? null : laCommons.trim();
    }

    public String getLaLocation() {
        return laLocation;
    }

    public void setLaLocation(String laLocation) {
        this.laLocation = laLocation == null ? null : laLocation.trim();
    }

    public String getLaIsCheck() {
        return laIsCheck;
    }

    public void setLaIsCheck(String laIsCheck) {
        this.laIsCheck = laIsCheck == null ? null : laIsCheck.trim();
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }


}
