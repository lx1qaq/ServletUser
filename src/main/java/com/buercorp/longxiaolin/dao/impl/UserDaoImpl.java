package com.buercorp.longxiaolin.dao.impl;

import com.buercorp.longxiaolin.dao.UserDao;
import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.pojo.UserInfo;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author 小林
 * Create on 2024/3/15 20:05
 */
public class UserDaoImpl implements UserDao {
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
    public boolean insertUser(User user) {


        //4. 使用DBUtils将用户信息存储到数据库
        //这里需要mysql驱动、druid、dbutils的jar包
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "insert into user values (null,?,?,?,?,?,?,?)";
        int insert = 0;
        try {  //将user用户存储的数据 插入 到数据库中
            insert = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());

//        // 将用户信息设置为请求属性
//        request.setAttribute("userInfo",userInfo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insert > 0;
    }

    @Override
    public boolean updateUser(User user) {

        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "update user set name=?,password=?,address=?nickname=?,gender=?,email=? Where id=?";
        int update = 0;
        //将user用户存储的数据 插入 到数据库中
        try {
            update = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
            User newUser = new User(user.getId(), user.getNickname(), user.getAddress(), user.getGender(), user.getEmail(), user.getPassword(), user.getUsername());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update > 0;
    }

    @Override
    public User getUser(String username, String password) {
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user;
        try {
            //执行查询，查询一条数据，封装到User中
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
