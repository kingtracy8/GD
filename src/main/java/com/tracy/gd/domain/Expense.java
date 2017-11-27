package com.tracy.gd.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    private Integer eId;

    private Integer eLaId;

    private Integer eLaCptId;

    private Integer eLaUserId;

    private Date eLendTime;

    private Date eSreturnTime;

    private Date eAreturnTime;

    private String eIsReturned;

    private Integer eDays;

    private BigDecimal eExpense;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer geteLaId() {
        return eLaId;
    }

    public void seteLaId(Integer eLaId) {
        this.eLaId = eLaId;
    }

    public Integer geteLaCptId() {
        return eLaCptId;
    }

    public void seteLaCptId(Integer eLaCptId) {
        this.eLaCptId = eLaCptId;
    }

    public Integer geteLaUserId() {
        return eLaUserId;
    }

    public void seteLaUserId(Integer eLaUserId) {
        this.eLaUserId = eLaUserId;
    }

    public Date geteLendTime() {
        return eLendTime;
    }

    public void seteLendTime(Date eLendTime) {
        this.eLendTime = eLendTime;
    }

    public Date geteSreturnTime() {
        return eSreturnTime;
    }

    public void seteSreturnTime(Date eSreturnTime) {
        this.eSreturnTime = eSreturnTime;
    }

    public Date geteAreturnTime() {
        return eAreturnTime;
    }

    public void seteAreturnTime(Date eAreturnTime) {
        this.eAreturnTime = eAreturnTime;
    }

    public String geteIsReturned() {
        return eIsReturned;
    }

    public void seteIsReturned(String eIsReturned) {
        this.eIsReturned = eIsReturned == null ? null : eIsReturned.trim();
    }

    public Integer geteDays() {
        return eDays;
    }

    public void seteDays(Integer eDays) {
        this.eDays = eDays;
    }

    public BigDecimal geteExpense() {
        return eExpense;
    }

    public void seteExpense(BigDecimal eExpense) {
        this.eExpense = eExpense;
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