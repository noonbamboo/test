<%@ page import="java.util.List" %>
<%@ page import="com.noonbamboo.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2022/12/30
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>显示所有信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  </head>
  <body>
  <c:if test="${empty sessionScope.account}">
    <c:redirect url="UserServlet?page=login&state=nli"></c:redirect>
  </c:if>
  <span style="color: red; ">${errMessage}</span><br>
  <table class="table table-striped">
    <tr>
      <th>id</th>
      <th>username</th>
      <th>password</th>
      <th>money</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${allUser}" var="u">
      <tr>
        <td>${u.id}</td>
        <td>${u.name}</td>
        <td>${u.password}</td>
        <td>${u.money}</td>
        <td>
          <a class="btn btn-primary" role="button" href="ShowUpdateUser?id=${u.id}">
            修改
          </a>
          <a class="btn btn-warning" role="button" href="DeleteUserControl?id=${u.id}">
            删除
          </a>
        </td>
      </tr>

    </c:forEach>
  </table>

  </body>
</html>
