package com.buercorp.longxiaolin.dao;

import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author 小林
 * Create on 2024/3/15 20:05
 */
public class UserDaoImpl implements UserDao{
    @Override
    public boolean deleteUser(int userId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "delete from user where id= ?";
        //将user用户存储的数据 插入 到数据库中
        int update = 0;
        try {
            update = queryRunner.update(sql, userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update > 0;
    }

    @Override
    public boolean insertUser(int userId) {
        return false;
    }

    @Override
    public boolean updateUser(int userId, String username) {
        return false;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }
}
