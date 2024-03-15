package com.buercorp.longxiaolin.dao;

import com.buercorp.longxiaolin.pojo.User;

/**
 * @author 小林
 * Create on 2024/3/15 20:04
 */
public interface UserDao {

    boolean deleteUser(int userId);

    boolean insertUser(int userId);

    boolean updateUser(int userId, String username);

    User getUser(int userId);
}
