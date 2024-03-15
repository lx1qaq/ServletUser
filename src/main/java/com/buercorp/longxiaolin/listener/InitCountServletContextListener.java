package com.buercorp.longxiaolin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 小林
 * Create on 2024/3/15 16:12
 */
@WebListener
public class InitCountServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化number,然后存进ServletContext
        int number = 0;
        sce.getServletContext().setAttribute("number", number);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
