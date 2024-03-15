package com.buercorp.longxiaolin.servlet;

import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.serive.DeleteUserServiceImpl;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * @author 小林
 * Create on 2024/3/15 18:13
 */
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setResponseHeader(request, response);

        // 获取要删除的用户ID
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();

        if (user == null) {
            System.out.println("无法从Session中获取到用户ID");
            // 处理无法获取用户ID的情况，比如跳转到错误页面或返回错误信息
            response.sendRedirect("/ServletUser/login.html");
            return;
        }

        System.out.println("从Session中获取到的用户ID：" + userId);
        DeleteUserServiceImpl deleteUserService = new DeleteUserServiceImpl();
        boolean isDeleteSucc = deleteUserService.deleteUser(user);
        if (isDeleteSucc) {
            HttpSession session = request.getSession();
            session.invalidate();
//         删除成功后跳转至成功页面
            response.sendRedirect("/ServletUser/index.html");
        } else {
            System.out.println("删除失败");
            // 删除失败，跳转至失败页面
            response.getWriter().write("删除失败");
//                response.sendRedirect("/ServletUser/userinfo.jsp");
        }
    }


    private static void setResponseHeader(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //1. 在最前面解决乱码问题:请求参数的中文乱码，响应的中文乱码
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        doGet(request, response);
    }
}