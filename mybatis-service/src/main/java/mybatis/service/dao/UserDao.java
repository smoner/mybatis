package mybatis.service.dao;

import mybatis.service.domain.User;

import java.util.HashMap;
import java.util.List;

/**
 * 功能概要：User的DAO类
 */
public interface UserDao {
    /**
     * @param userId
     * @return
     */
    public User selectUserById(Integer userId);
    public User selectUserByName(String userName);
    public void updateUserById(User user);
    public Integer insertUser(User user);
    public Integer deleteUserById(Integer userId);
    public Integer batchInsertUser(List<User> users);
    public Integer batchUpdateUser(List<User> users);
    public Integer batchDeleteUser(List<User> users);
    public List<User> batchQueryUser(List<User> users);
    public List<HashMap> batchQueryUserMap(List<User> users);
}