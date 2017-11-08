package com.tracy.gd.service;

import com.tracy.gd.domain.Admin;

import java.util.List;

/**
 * Created by trcay on 2017/10/28.
 */
public interface IAdminService {
    public List<Admin> selectUserAdmins();
    public Admin getAdminById(int adminId);
    public int deleteByPrimaryKey(int adminId);
}
