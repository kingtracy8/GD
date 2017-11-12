package com.tracy.gd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LendingApply {
    private Integer laId;

    private Integer laUserId;

    private Integer laCptId;

    private String laReason;

    private Date laLendTime;

    private Date laReturnTime;

    private String laCommons;

    private String laLocation;

    private String laIsCheck;

    private String attribute1;

    private String attribute2;

    private String attribute3;

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
}