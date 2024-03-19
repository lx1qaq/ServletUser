package com.buercorp.longxiaolin.serive.impl;

import com.buercorp.longxiaolin.dao.impl.UserDaoImpl;
import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.serive.UserService;

/**
 * @author 小林
 * Create on 2024/3/15 19:59
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean insertUser(User user) {
        userDao.insertUser(user);
        return true;
    }

    @Override
    public boolean updateUser(Integer id, User user) {
        userDao.updateUser(id, user);
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        User user = userDao.getUser(username, password);
        return user;
    }

    @Override
    public boolean deleteUser(User user) {
        userDao.deleteUser(user.getId());

        ///
        ///

        return true;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
