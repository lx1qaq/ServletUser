package com.buercorp.longxiaolin.serive.impl;

import com.buercorp.longxiaolin.dao.impl.UserDaoImpl;
import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.serive.UserService;

/**
 * @author 小林
 * Create on 2024/3/15 19:59
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean insertUser(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.updateUser(user);
        return true;
    }

    @Override
    public User getUser(String username,String password) {
        UserDaoImpl userDao=new UserDaoImpl();
        User user = userDao.getUser(username,password);
        return user;
    }

    @Override
    public boolean deleteUser(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.deleteUser(user.getId());

        ///
        ///

        return true;
    }
}
