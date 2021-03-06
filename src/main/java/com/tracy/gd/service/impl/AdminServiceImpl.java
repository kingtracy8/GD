package com.tracy.gd.service.impl;

import com.tracy.gd.IDao.AdminMapper;
import com.tracy.gd.domain.Admin;
import com.tracy.gd.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by trcay on 2017/10/28.
 */
@Service("adminService")
//@Transactional(value="transactionManager",propagation= Propagation.REQUIRED, rollbackFor={Exception.class, RuntimeException.class})
public class AdminServiceImpl implements IAdminService{

    //@Resource
    @Autowired
    AdminMapper adminMapper;


    public List<Admin> selectUserAdmins() {
        return adminMapper.selectUserAdmins();
    }

    public Admin getAdminById(int adminId) {
        return this.adminMapper.selectByPrimaryKey(adminId);
    }

    public int deleteByPrimaryKey(int adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }
//    @Transactional(value="transactionManager",propagation= Propagation.REQUIRED, rollbackFor={Exception.class, RuntimeException.class})
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }
}
