package com.tracy.gd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by trcay on 2017/12/24.
 * 缴费管理页面响应的dto
 */
public class updateExpense {

    private Integer laId;

    private String userName;

    private String cptName;

    private Date LendTime;

    private Date AreturnTime;

    private String IsReturned;

    private Integer Days;

    private BigDecimal Expense;



    private String IsPay;

    public Integer getLaId() {
        return laId;
    }

    public void setLaId(Integer laId) {
        this.laId = laId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCptName() {
        return cptName;
    }

    public void setCptName(String cptName) {
        this.cptName = cptName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getLendTime() {
        return LendTime;
    }

    public void setLendTime(Date lendTime) {
        LendTime = lendTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAreturnTime() {
        return AreturnTime;
    }

    public void setAreturnTime(Date areturnTime) {
        AreturnTime = areturnTime;
    }

    public String getIsReturned() {
        return IsReturned;
    }

    public void setIsReturned(String isReturned) {
        IsReturned = isReturned;
    }

    public Integer getDays() {
        return Days;
    }

    public void setDays(Integer days) {
        Days = days;
    }

    public BigDecimal getExpense() {
        return Expense;
    }

    public void setExpense(BigDecimal expense) {
        Expense = expense;
    }

    public String getIsPay() {
        return IsPay;
    }

    public void setIsPay(String isPay) {
        IsPay = isPay;
    }

}
