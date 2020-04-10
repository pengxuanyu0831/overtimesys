<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/30
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello moto</title>
</head>
<body>
<a href = "${pageContext.request.contextPath}/users/findUser">查询用户</a>
<hr>
<form method="post" action="${pageContext.request.contextPath}/users/insert">
    用户名:<input type = "text" name = "name"><br>
    密码：<input type = "text" name = "password"><br>
    邮箱：<input type = "text" name = "email"><br>
    <input type = "submit" name = "注册"><br>
</form>
<hr>
<form method="post" action="${pageContext.request.contextPath}/users/login">
    用户名:<input type = "text" name = "name"><br>
    密码:<input type ="text" name = "password"><br>
    <input type = "submit" name = "查询"><br>
</form>
<hr>
</body>
</html>

