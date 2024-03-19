<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<h1>User Information</h1>
<h1>当前在线人数:</h1>
<div> ${number} 人 </div>

<a href="/ServletUser/LogoutServlet">退出登录</a>

<%
    // 从 Session 中获取用户信息
    com.buercorp.longxiaolin.pojo.User user = (com.buercorp.longxiaolin.pojo.User) session.getAttribute("user");
    if (user != null) {
%>
<p><strong>昵称:</strong> <%= user.getNickname() %></p>
<p><strong>地址:</strong> <%= user.getAddress() %></p>
<p><strong>性别:</strong> <%= user.getGender() %></p>
<p><strong>邮箱:</strong> <%= user.getEmail() %></p>
<%
} else {
%>
<p>No user information available.</p>
<%
    }
%>
<a href="/ServletUser/updatel.html">修改个人信息</a>

<a href="/ServletUser/delete">删除改用户</a>
</body>
</html>