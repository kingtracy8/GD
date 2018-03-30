package com.tracy.gd.IDao;

import com.tracy.gd.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    public List<Admin> selectUserAdmins();
}