package com.tracy.gd.service;

import com.tracy.gd.domain.Admin;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by trcay on 2017/10/28.
 */

public interface IAdminService {
    public List<Admin> selectUserAdmins();
    public Admin getAdminById(int adminId);
    public int deleteByPrimaryKey(int adminId);
//    @Transactional(value="transactionManager",propagation= Propagation.REQUIRED, rollbackFor={Exception.class, RuntimeException.class})
    public int insertSelective(Admin record);
}
