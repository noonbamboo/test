<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2022/12/30
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body style="background: #F2E8DF;display: flex;justify-content: center;align-items: center">
<div style="width: 500px;padding: 20px 100px;background: white;">
    <form action="RegisterControl" method="post">
        <span style="color: red; ">${errMessage}</span><br>
        <div class="form-group">
            <label for="account">账户：</label>
            <input type="text" name="account" class="form-control" placeholder="输入用户名" id="account">
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" placeholder="输入密码" id="password">
        </div>
        <div class="form-group">
            <label for="money">元宝：</label>
            <input type="text" name="money" class="form-control" id="money">
        </div>

        <button type="submit" class="btn btn-primary btn-block">注册</button>
    </form>
</div>

</body>
</html>
