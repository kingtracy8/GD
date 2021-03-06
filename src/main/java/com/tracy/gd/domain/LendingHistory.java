package com.tracy.gd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Transient;
import java.util.Date;

public class LendingHistory {
    private Integer lhId;

    private Integer lhUserId;

    private Integer lhLaId;

    private Integer lhWhoChecked;

    private Date lhCheckTime;

    private String lhIsCheck;

    private String laCommons;

    private String attribute1;

    private String attribute2;

    private String attribute3;


    @Transient      //谁审核的
    private String userName;


    @Transient       //审核人的身份
    private String userIdentity;

    @Transient  //关联费用表查看是否已经归还 2017-12-05 17:53:17
    private String eIsReturned;

    @Transient
    private String cptName;

    public String getCptName() {
        return cptName;
    }

    public void setCptName(String cptName) {
        this.cptName = cptName;
    }

    public String geteIsReturned() {
        return eIsReturned;
    }

    public void seteIsReturned(String eIsReturned) {
        this.eIsReturned = eIsReturned;
    }


    public Integer getLhId() {
        return lhId;
    }

    public void setLhId(Integer lhId) {
        this.lhId = lhId;
    }

    public Integer getLhUserId() {
        return lhUserId;
    }

    public void setLhUserId(Integer lhUserId) {
        this.lhUserId = lhUserId;
    }

    public Integer getLhLaId() {
        return lhLaId;
    }

    public void setLhLaId(Integer lhLaId) {
        this.lhLaId = lhLaId;
    }

    public Integer getLhWhoChecked() {
        return lhWhoChecked;
    }

    public void setLhWhoChecked(Integer lhWhoChecked) {
        this.lhWhoChecked = lhWhoChecked;
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getLhCheckTime() {
        return lhCheckTime;
    }

    public void setLhCheckTime(Date lhCheckTime) {
        this.lhCheckTime = lhCheckTime;
    }

    public String getLhIsCheck() {
        return lhIsCheck;
    }

    public void setLhIsCheck(String lhIsCheck) {
        this.lhIsCheck = lhIsCheck == null ? null : lhIsCheck.trim();
    }

    public String getLaCommons() {
        return laCommons;
    }

    public void setLaCommons(String laCommons) {
        this.laCommons = laCommons == null ? null : laCommons.trim();
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