package com.wen.test;


import com.wen.test.Dao.UserDao;
import com.wen.test.vo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() throws Exception {
        /**
         * 用于更新或者增加操作时用到
         */
        Users userss = new Users();
        userss.setUsername("gg");
        userss.setUser_id(1);
        userss.setPassword("12312313");
        Users users=userDao.findUsersByUser_id(1);
	    System.out.println("第一次查询："+users.getUsername());
        System.out.println("------------完美分割线----------------");
        System.out.println("开始更新操作");
        userDao.save(userss);
        Users u2=userDao.findUsersByUser_id(1);
        System.out.println("第二次查询："+u2.getUsername());



    }


}
