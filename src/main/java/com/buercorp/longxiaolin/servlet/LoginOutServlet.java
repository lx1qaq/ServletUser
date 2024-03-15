package com.buercorp.longxiaolin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Handler;

/**
 * @author 小林
 * Create on 2024/3/15 16:19
 */
@WebServlet("/LogoutServlet")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 销毁session
        request.getSession().invalidate();
        response.getWriter().write("logout");
        response.sendRedirect("/ServletUser/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
