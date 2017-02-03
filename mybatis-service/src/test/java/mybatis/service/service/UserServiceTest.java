package mybatis.service.service;

import mybatis.service.basetest.SpringTestCase;
import mybatis.service.domain.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 功能概要：UserService单元测试
 *
 * @author linbingwen
 * @since 2015年9月28日
 */
public class UserServiceTest extends SpringTestCase {
    @Autowired
    private IUserService userService;
    Logger logger = Logger.getLogger(UserServiceTest.class);

    @Test
    public void selectUserByIdTest() {
        User user = userService.selectUserById(10);
        logger.debug("查找结果" + user);
    }

    @Test
    public void selectUserByNameTest() {
        User user = userService.selectUserByName("test001");
        logger.debug("查找结果" + user);
    }
    @Test
    public void updateUserByIdTest(){
        User user = new User();
        user.setUserName("test001_new");
        user.setUserId(10);
        userService.updateUserById(user);
    }
    @Test
    public void insertUser() throws Exception{
        User user = new User();
        user.setUserName("test002");
        user.setUserId(2);
        user.setUserPassword("test002");
        user.setUserEmail("test002@qq.com");
        Integer integer =userService.insertUser(user);
        logger.debug("新插入数据:"+integer);
    }
    @Test
    public void deleteUserByIdTest() throws Throwable {
        Integer integer = userService.deleteUserById(2);
        logger.debug("删除的用户:"+integer);
    }

    @Test
    public void batchInsertUserTest(){
        List<User> userList = new ArrayList<User>();
        for(int i = 10;i<20;i++){
            User user = new User();
            user.setUserName("test"+i);
            user.setUserId(i);
            user.setUserPassword("test"+i);
            user.setUserEmail("test"+i+"@qq.com");
            userList.add(user);
        }
        Integer integer =userService.batchInsertUser(userList);
        logger.debug("新插入数据:"+integer);
    }

    @Test
    public void batchUpdateUserTest(){
        List<User> userList = new ArrayList<User>();
        for(int i = 10;i<20;i++){
            User user = new User();
            user.setUserName("test"+i+"_new");
            user.setUserId(i);
            user.setUserPassword("test"+i+"_new");
            user.setUserEmail("test"+i+"_new"+"@qq.com");
            userList.add(user);
        }
        Integer integer =userService.batchUpdateUser(userList);
        logger.debug("新插入数据:"+integer);
    }
    @Test
    public void batchDeleteUser(){
        List<User> userList = new ArrayList<User>();
        for(int i = 10;i<15;i++){
            User user = new User();
            user.setUserName("test"+i+"_new");
            user.setUserId(i);
            user.setUserPassword("test"+i+"_new");
            user.setUserEmail("test"+i+"_new"+"@qq.com");
            userList.add(user);
        }
        Integer integer =userService.batchDeleteUser(userList);
        logger.debug("新插入数据:"+integer);
    }


    @Test
    public void batchQueryUser(){
        List<User> userList = new ArrayList<User>();
        for(int i = 15;i<20;i++){
            User user = new User();
            user.setUserId(i);
            userList.add(user);
        }
        List<User> userList2 = new ArrayList<User>();
        userList2 =userService.batchQueryUser(userList);
        logger.debug("新插入数据:"+userList2);
    }

    @Test
    public void batchQueryUserMap(){
        List<User> userList = new ArrayList<User>();
        for(int i = 15;i<20;i++){
            User user = new User();
            user.setUserId(i);
            userList.add(user);
        }
        List<HashMap> userList2 = new ArrayList<HashMap>();
        userList2 =userService.batchQueryUserMap(userList);
        logger.debug("新插入数据:"+userList2);
    }
    @Test
    public void transactrionTest() throws Throwable {
        User user = new User();
        user.setUserName("test"+33+"_new");
        user.setUserId(33);
        user.setUserPassword("test"+33+"_new");
        user.setUserEmail("test"+33+"_new"+"@qq.com");


        User user2 = new User();
        user2.setUserName("test4"+16+"_new");
        user2.setUserId(16);
        user2.setUserPassword("test"+16+"_new");
        user2.setUserEmail("test"+16+"_new2"+"@qq.com");

//        userService.deleteUserById(user.getUserId());
        userService.transactrionTest(user,user2);
    }
}