package com.buercorp.longxiaolin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author 小林
 * Create on 2024/3/14 17:41
 */

@WebFilter("/*")
public class indexFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;



        // 获取请求路径
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

        // 检查是否是登录页面或者已经登录
        if ("/ServletUser/index.html".equals(path) || checkUserLoggedIn(httpServletRequest)) {
            // 用户已登录或访问的是登录页面，继续处理请求
            chain.doFilter(request, response);
        } else {
            // 用户未登录，重定向到登录页面
            httpServletResponse.sendRedirect("/ServletUser/index.html");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private boolean checkUserLoggedIn(HttpServletRequest request) {
        // 在这里实现你的用户登录检查逻辑，返回 true 表示已登录，返回 false 表示未登录
        // 可以根据 HttpSession 或者其他方式来判断用户是否已登录

        Object user = request.getSession().getAttribute("user");

        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
