package mybatis.service.service;

import mybatis.service.domain.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by smoner on 2017/1/31.
 */
public interface IUserService {
    User selectUserById(Integer userId);
    User selectUserByName(String userName);
    void updateUserById(User user);
    Integer insertUser(User user) throws Exception;
    Integer deleteUserById(Integer userId) throws Throwable;
    Integer batchInsertUser(List<User> users);
    Integer batchUpdateUser(List<User> users);
    Integer batchDeleteUser(List<User> users);
    List<User> batchQueryUser(List<User> users);
    List<HashMap> batchQueryUserMap(List<User> users);
    void transactrionTest(User newUser ,User oldUser) throws Exception;
}
