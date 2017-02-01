package mybatis.service.service;

import mybatis.service.domain.User;

/**
 * Created by smoner on 2017/1/31.
 */
public interface IUserService {
    User selectUserById(Integer userId);
}
