<%--
  Created by IntelliJ IDEA.
  User: pengxy
  Date: 2020/6/2
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注 册</title>

    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- particles 背景-->
    <link rel ="stylesheet" media="screen" href="css/style.css">

    <!--bootstrap & bootstrapValidator  -->
    <link rel="stylesheet" href = "css/bootstrap.css"/>
    <link rel="stylesheet" href = "css/bootstrapValidator.min.css">
    <link rel="stylesheet" href = "css/bootstrapValidator.css"/>

    <!-- sweetalert提示 -->
    <script src = "js/sweetalert.js"></script>
    <link rel ="stylesheet" type = "text/css" href = "css/sweetalert.css">


    <script src = "/js/registered.js"></script>
</head>
<body>
<div id = "particles-js">
    <div class="container" style="position: absolute;left: 120px;">
        <form:form modelAttribute="infoModel" method="post"></form:form>
        <form id = "RegisterForm" method="post" name = "RegisterForm" action="${pageContext.request.contextPath}/users/insertUser">
            <div class = "form-group">
                <from:errors path="*"></from:errors>
                <label class="col-lg-3 control-label">用户名:</label>
                <div class="col-lg-4 ">
                    <input type = "text" name = "name" placeholder="请输入用户名"
                           data-bv-notempty
                           data-bv-notempty-message = "姓名不能为空"
                           data-bv-stringLength = "true"
                           data-bv-stringLength-min = 4
                           data-bv-stringLength-max = 16
                           data-bv-stringLength-message = "用户名长度限制在4-16位之间">
                    <form:errors path="name"></form:errors>
                </div>
            </div>

            <div class = "form-group">
                <label class="col-lg-3 control-label">密码:</label>
                <div class="col-lg-4">
                    <input type = "password" name = "password" placeholder="必须包含数字、字母、符号中的两种">
                    <form:errors path="pasword"></form:errors>
                </div>
            </div>

            <div class = "form-group">
                <label class="col-lg-3 control-label">邮箱:</label>
                <div class="col-lg-4">
                    <input type = "text" name = "email" placeholder="请输入邮箱地址"
                           data-bv-emailAddress = "true"
                           data-bv-emailAddress-message = "请输入正确格式的邮箱地址">
                    <form:errors path="email"></form:errors>
                </div>
            </div>

            <div class = "col-lg-offset-2">
                <button type = "submit" class = " btn btn-primary" name = "Registered" id="RegisteredBtn">注册</button>
            </div>
            <hr>
            <div class = "form-group">
                <a href="${pageContext.request.contextPath}/index.jsp">去登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
