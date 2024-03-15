package com.buercorp.longxiaolin.serive;

import com.buercorp.longxiaolin.dao.UserDaoImpl;
import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author 小林
 * Create on 2024/3/15 19:59
 */
public class DeleteUserServiceImpl implements DeleteUserService{


    @Override
    public boolean deleteUser(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.deleteUser(user.getId());

        ///
        ///

        return true;
    }
}
