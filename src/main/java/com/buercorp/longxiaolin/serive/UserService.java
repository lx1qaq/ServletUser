package com.buercorp.longxiaolin.serive;

import com.buercorp.longxiaolin.pojo.User;

/**
 * @author 小林
 * Create on 2024/3/15 19:58
 */
public interface UserService {


    boolean insertUser(User user);

    boolean updateUser(Integer id,User user);

    User getUser(String username,String password);

    boolean deleteUser(User user);

    User getUserById(Integer id);
}
