package com.buercorp.longxiaolin.servlet;

import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 小林
 * Create on 2024/3/15 17:47
 */
@WebServlet("/Updata")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 在最前面解决乱码问题:请求参数的中文乱码，响应的中文乱码
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=UTF-8");
        try {
            // 获取用户ID
            Integer userId = Integer.valueOf(request.getParameter("userId"));

            User user = new User();
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "update user set name=?,password=?,address=?nickname=?,gender=?,email=?";
            //将user用户存储的数据 插入 到数据库中

            queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());


            User newUser = new User(userId, user.getNickname(), user.getAddress(), user.getGender(), user.getEmail(), user.getPassword(), user.getUsername());

            // 将用户信息设置为请求属性
            request.setAttribute("user", newUser);
            System.out.println();

            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);

            response.sendRedirect("/ServletUser/userinfo.jsp");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
