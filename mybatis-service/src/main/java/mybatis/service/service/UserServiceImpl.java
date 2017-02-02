package mybatis.service.service;

import mybatis.service.dao.UserDao;
import mybatis.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by smoner on 2017/1/31.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    public User selectUserByName(String userName) {
        return userDao.selectUserByName(userName);
    }

    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    public Integer insertUser(User user) {
        Integer integer =  userDao.insertUser(user);
        return integer ;
    }

    public Integer deleteUserById(Integer integer) throws Throwable {
        try{
            userDao.deleteUserById(integer);
        }catch (Exception e){
            throw new Throwable(e.getMessage());
        }
        return integer;
    }

    public Integer batchInsertUser(List<User> users) {
        return userDao.batchInsertUser(users);
    }

    public Integer batchUpdateUser(List<User> users) {
        return userDao.batchUpdateUser(users);
    }

    public Integer batchDeleteUser(List<User> users) {
        return userDao.batchDeleteUser(users);
    }

    public List<User> batchQueryUser(List<User> users) {
        return userDao.batchQueryUser(users);
    }

    public List<HashMap> batchQueryUserMap(List<User> users) {
        return userDao.batchQueryUserMap(users);
    }
}
