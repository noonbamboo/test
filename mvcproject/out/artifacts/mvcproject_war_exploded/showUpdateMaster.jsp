<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.noonbamboo.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2022/12/30
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body style="background: #F2E8DF;display: flex;justify-content: center;align-items: center">
<c:if test="${empty sessionScope.account}">
    <c:redirect url="UserServlet?page=login&state=nli"></c:redirect>
</c:if>

<div style="width: 500px;padding: 20px 100px;background: white;">
    <span style="color: red; ">${errMessage}</span><br>
    <form action="UpdateUserControl" method="post">
        <div class="form-group">
            <label for="user-id">用户id</label>
            <input type="text" name="id" class="form-control" value="${user.id}" id="user-id" readonly>
        </div>
        <div class="form-group">
            <label for="account">账户：</label>
            <input type="text" name="username" class="form-control" placeholder="输入用户名" value="${user.name}" id="account">
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" placeholder="输入密码" value="${user.password}" id="password">
        </div>
        <div class="form-group">
            <label for="money">元宝：</label>
            <input type="text" name="money" class="form-control" placeholder="输入元宝数" value="${user.money}" id="money">
        </div>

        <button type="submit" class="btn btn-primary btn-block">修改</button>
    </form>
</div>



</body>
</html>
