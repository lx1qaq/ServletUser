<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<h1>User Information</h1>
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
</body>
</html>