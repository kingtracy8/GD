package com.tracy.gd.domain;

public class ExpenseRatio {
    private Integer rId;

    private Integer rFreeDays;

    private Integer rBaseNum;

    private Float rExpense;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getrFreeDays() {
        return rFreeDays;
    }

    public void setrFreeDays(Integer rFreeDays) {
        this.rFreeDays = rFreeDays;
    }

    public Integer getrBaseNum() {
        return rBaseNum;
    }

    public void setrBaseNum(Integer rBaseNum) {
        this.rBaseNum = rBaseNum;
    }

    public Float getrExpense() {
        return rExpense;
    }

    public void setrExpense(Float rExpense) {
        this.rExpense = rExpense;
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