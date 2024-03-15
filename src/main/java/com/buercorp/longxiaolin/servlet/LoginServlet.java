package com.buercorp.longxiaolin.servlet;

import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 小林
 * Create on 2024/3/14 15:39
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {


            //1. 在最前面解决乱码问题:请求参数的中文乱码，响应的中文乱码
            //解决请求参数的中文乱码
            request.setCharacterEncoding("UTF-8");
            //解决响应中文乱码
            response.setContentType("text/html;charset=UTF-8");

            //2. 获取请求参数username和password
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("登录用户名: " + username + ", 密码:" + password);

            //3. 连接数据库校验用户名和密码，也就是执行查询的SQL语句
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "select * from user where username=? and password=?";

            //执行查询，查询一条数据，封装到User中
            User user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
            System.out.println("查询到的user数据: " + user);

            //4.存在user数据，则登录成功，否之，失败
            if (user != null) {
                // 登录成功，将用户信息存储在 Session 中
                request.getSession().setAttribute("user", user);
                // 登录成功后跳转至个人信息页面
                response.sendRedirect("/ServletUser/userinfo.jsp");
            } else {
                // 登录失败
                response.getWriter().write("登录失败");
            }
        } catch (Exception e) {
            // 登录失败
            response.getWriter().write("登录失败");
            // 抛出运行时异常
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
