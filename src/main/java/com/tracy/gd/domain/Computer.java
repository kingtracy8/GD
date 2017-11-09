package com.tracy.gd.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Computer {
    private Integer cptId;

    private String cptName;

    private BigDecimal cptPrice;

    private String cptIcon;

    private String cptOs;

    private String cptCpu;

    private String cptRam;

    private String cptRom;

    private String cptScreensize;

    private String cptGraphicscard;

    private String cptIslending;

    private Date cptLendtime;

    private Date cptReturntime;

    private Integer cptWho;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    public Integer getCptId() {
        return cptId;
    }

    public void setCptId(Integer cptId) {
        this.cptId = cptId;
    }

    public String getCptName() {
        return cptName;
    }

    public void setCptName(String cptName) {
        this.cptName = cptName == null ? null : cptName.trim();
    }

    public BigDecimal getCptPrice() {
        return cptPrice;
    }

    public void setCptPrice(BigDecimal cptPrice) {
        this.cptPrice = cptPrice;
    }

    public String getCptIcon() {
        return cptIcon;
    }

    public void setCptIcon(String cptIcon) {
        this.cptIcon = cptIcon == null ? null : cptIcon.trim();
    }

    public String getCptOs() {
        return cptOs;
    }

    public void setCptOs(String cptOs) {
        this.cptOs = cptOs == null ? null : cptOs.trim();
    }

    public String getCptCpu() {
        return cptCpu;
    }

    public void setCptCpu(String cptCpu) {
        this.cptCpu = cptCpu == null ? null : cptCpu.trim();
    }

    public String getCptRam() {
        return cptRam;
    }

    public void setCptRam(String cptRam) {
        this.cptRam = cptRam == null ? null : cptRam.trim();
    }

    public String getCptRom() {
        return cptRom;
    }

    public void setCptRom(String cptRom) {
        this.cptRom = cptRom == null ? null : cptRom.trim();
    }

    public String getCptScreensize() {
        return cptScreensize;
    }

    public void setCptScreensize(String cptScreensize) {
        this.cptScreensize = cptScreensize == null ? null : cptScreensize.trim();
    }

    public String getCptGraphicscard() {
        return cptGraphicscard;
    }

    public void setCptGraphicscard(String cptGraphicscard) {
        this.cptGraphicscard = cptGraphicscard == null ? null : cptGraphicscard.trim();
    }

    public String getCptIslending() {
        return cptIslending;
    }

    public void setCptIslending(String cptIslending) {
        this.cptIslending = cptIslending == null ? null : cptIslending.trim();
    }

    public Date getCptLendtime() {
        return cptLendtime;
    }

    public void setCptLendtime(Date cptLendtime) {
        this.cptLendtime = cptLendtime;
    }

    public Date getCptReturntime() {
        return cptReturntime;
    }

    public void setCptReturntime(Date cptReturntime) {
        this.cptReturntime = cptReturntime;
    }

    public Integer getCptWho() {
        return cptWho;
    }

    public void setCptWho(Integer cptWho) {
        this.cptWho = cptWho;
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