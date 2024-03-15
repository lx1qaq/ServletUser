package com.buercorp.longxiaolin.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 小林
 * Create on 2024/3/15 16:14
 */
@WebListener
public class CountSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 获取HttpSession域对象
        HttpSession session = se.getSession();

        // 获取 ServletContext
        ServletContext servletContext = session.getServletContext();
        // 增加number值
        int number = (int) servletContext.getAttribute("number");
        number++;
        servletContext.setAttribute("number",number);

        System.out.println("有让人上线");
    }

    // session销毁,就会执行
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 获取HttpSession域对象
        HttpSession session = se.getSession();

        ServletContext servletContext = session.getServletContext(); // 获取 ServletContext
        int number = (int) servletContext.getAttribute("number"); // 减少number值
        number--;
        servletContext.setAttribute("number", number);

        System.out.println("有人下线了....");
    }
}
