package com.tracy.gd.IDao;

import com.tracy.gd.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //添加分页，2017-12-08 19:15:29  linsong.wei
    List<User> selectAllToTable(Integer page, Integer limit);

    List<User> selectAll();

    //防止用户在更新自己信息的时候把身份标识去掉 2017-11-21 10:02:53
    int ChangePersonalMsg(User record);

    List<User> selectUserFilter(@Param("userName") String userName, @Param("userNum") String userNum, @Param("userPhone") String userPhone, @Param("userDepartment") String userDepartment, @Param("userGender") String userGender, @Param("attribute1") String attribute1, @Param("start") Integer start,@Param("offset") Integer offset);

    //为支持table模块分页，需查询出总数 linsong.wei 2017-12-08 19:05:02
    int selectCountUser();

    int selectCountUserFilter(@Param("userName") String userName, @Param("userNum") String userNum, @Param("userPhone") String userPhone, @Param("userDepartment") String userDepartment, @Param("userGender") String userGender, @Param("attribute1") String attribute1);

    //通过用户名和身份去查找记录， 匹配密码 2017-12-10 13:07:28
    List<User> selectAllByUserName(@Param("userName") String userName,@Param("identity") String identity);
}