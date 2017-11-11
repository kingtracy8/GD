package org.zsl.testmybatis;  
  
import javax.annotation.Resource;

import com.tracy.gd.domain.Admin;
import com.tracy.gd.domain.Computer;
import com.tracy.gd.service.IAdminService;
import com.tracy.gd.service.IComputerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tracy.gd.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Resource  
    private IUserService userService = null;
    @Autowired
    IAdminService adminService;
    @Autowired
    IComputerService computerService;

    @Test  
    public void test1() {  
//        User user = userService.getUserById(1);
//        logger.info(JSON.toJSONString(user));
   /*     List<User> userList = userService.selectAll();
        User user = userService.getUserById(1);
        if(userList.contains(user)){
            logger.info(JSON.toJSONString(user));
        }
  */

   /*
        List<Admin> admins = new ArrayList<Admin>();
        admins = adminService.selectUserAdmins();
        for (int i = 0; i < admins.size(); i++) {
            logger.info(JSON.toJSONString(admins.get(i)));
        }

*/

//        Computer computer = computerService.selectByPrimaryKey(1);
        //logger.info(JSON.toJSONString(computer));
        Computer computer = new Computer();
        computer.setCptOs(null);
      //  computer.setCptGraphicscard("GT840M");
//        computer.setCptName("");
       // computer.setCptIslending("N");
        List<Computer> list = computerService.selectAllComputers(computer);
        logger.info(JSON.toJSONString(list));
    }  
}  