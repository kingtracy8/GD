package com.tracy.gd.dto;

/**
 * Created by tracy on 2017/11/11. 2017-11-11 13:51:03
 *作用： 检查密码实体类，用@RequestBody接收json 放到这个实体
 */
public class checkPass {

    private String orgPass;

    private String newPass;

    public String getOrgPass() {
        return orgPass;
    }

    public void setOrgPass(String orgPass) {
        this.orgPass = orgPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    private String confirmPass;

}
