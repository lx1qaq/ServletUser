package com.buercorp.longxiaolin.servlet;

import com.buercorp.longxiaolin.pojo.User;
import com.buercorp.longxiaolin.pojo.UserInfo;
import com.buercorp.longxiaolin.serive.impl.UserServiceImpl;
import com.buercorp.longxiaolin.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

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

        // 获取用户ID
        User sessionUser = (User) request.getSession().getAttribute("user");
        Integer id = sessionUser.getId();


        System.out.println("拿到的uid" + id);

        //2. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("接收到的参数: ");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + value);
            }
        }


        User user = new User();

        //设置默认的status为"0"
        user.setStatus("0");
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        UserServiceImpl userService = new UserServiceImpl();
        boolean b = userService.updateUser(id, user);
        User userById = userService.getUserById(id);


        UserInfo userInfo = new UserInfo(userById.getNickname(), userById.getAddress(), userById.getGender(), userById.getEmail());

        request.setAttribute("userInfo", userInfo);

        System.out.println(userInfo);

        System.out.println(userById);


        // 将用户信息设置为请求属性
        request.getSession().setAttribute("user", userById);

        response.sendRedirect("/ServletUser/userinfo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
