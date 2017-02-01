package mybatis.service.service;

import mybatis.service.basetest.SpringTestCase;
import mybatis.service.domain.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

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


}