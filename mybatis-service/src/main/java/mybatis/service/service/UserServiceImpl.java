package mybatis.service.service;

import mybatis.service.dao.UserDao;
import mybatis.service.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by smoner on 2017/1/31.
 */
@Service
public class UserServiceImpl implements IUserService {
    Logger logger =  Logger.getLogger(UserServiceImpl.class);
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

    public Integer insertUser(User user) throws Exception {
        Integer integer = null;
        try{
            integer =  userDao.insertUser(user);
            int e = 3/0 ;
        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new RuntimeException("test");
        }
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

    /**
     * 1.添加事务注解
     * 使用propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时如何使用事务。
     * 默认取值为REQUIRED，即使用调用方法的事务
     * REQUIRES_NEW：使用自己的事务，调用的事务方法的事务被挂起。
     *
     * 2.使用isolation 指定事务的隔离级别，最常用的取值为READ_COMMITTED
     * 3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置。通常情况下，默认值即可。
     * 4.使用readOnly 指定事务是否为只读。 表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务。若真的是一个只读取数据库值得方法，应设置readOnly=true
     * 5.使用timeOut 指定强制回滚之前事务可以占用的时间。
     */
    @Transactional(propagation= Propagation.REQUIRED,
            isolation= Isolation.READ_COMMITTED,
            noRollbackFor={Exception.class},
            readOnly=false, timeout=3)
    public void transactrionTest(User newUser ,User oldUser) throws Exception {
        //userDao.updateUserById(oldUser);
        //userDao.insertUser(newUser);
        this.updateUserById(oldUser);
        this.insertUser(newUser);
    }
}
