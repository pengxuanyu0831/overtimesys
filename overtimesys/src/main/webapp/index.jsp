<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pengxy
  Date: 2020/3/30
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Moto</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- particles 背景-->
    <link rel ="stylesheet" media="screen" href="css/style.css">

    <!--bootstrap & bootstrapValidator  -->
    <link rel="stylesheet" href = "css/bootstrap.css"/>
    <link rel="stylesheet" href = "css/bootstrapValidator.min.css">
    <link rel="stylesheet" href = "css/bootstrapValidator.css"/>

    <%-- sweetalert提示--%>
    <script src = "js/sweetalert2.min.js"></script>
    <link rel ="stylesheet" type = "text/css" href = "css/sweetalert2.min.css">

    <meta http-equiv="X-UA-Compattible" content="IE = edge,chrome=1">
    <meta name = "viewport" content="width=device-width,inital-scale=1.0">

</head>

<body>
<div class="count-particles">
    <span class="js-count-particles">--</span> particles
</div>
<div id = "particles-js">
    <div class="container" style="margin-top: 100px;">
        <div class="center">
            <section>
                <div class="col-lg-8 col-lg-offset-2">
                    <div class = "page-header">
                        <h1>Sign in</h1>
                    </div>
                    <div id = "login">
                        <a href = "${pageContext.request.contextPath}/users/findUser">查询用户</a>

                        <div>
                            <a href = "${pageContext.request.contextPath}/toRegister.jsp">去注册</a>
                        </div>

                        <hr>


                        <form method="post" action="${pageContext.request.contextPath}/users/login">
                            <div class = "form-group">
                                <div class =row >
                                <div class ="col-lg-5">
                                    <label class ="col-lg-4 control-label form-inline">用户名:</label>
                                    <input type = "text" name = "name">
                                </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class = row>

                                <div class ="col-lg-5 ">
                                    <label class ="col-lg-4 control-label form-inline">密码:</label>
                                    <input type ="password" name = "password">
                                </div>
                                </div>
                            </div>
                            <div class = "col-lg-4 col-lg=offset-2">
                                <button type = "submit" class = "btn btn-primary" name ="login">登录</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
            <script src="js/particles.min.js"></script>
            <script src ="js/app.js"></script>
            <script src="js/stats.js"></script>
            <!--jQuery -->
            <script type ="text/javascript" src = "js/jquery-3.1.1.min.js"></script>

            <script type ="text/javascript" src = "js/bootstrap.min.js"></script>
            <script type ="text/javascript" src ="js/bootstrapValidator.js"></script>
            <!-- 自定义的校验规则-->
            <!-- 引入的文件无效，不知道为啥，调用代码可能写错了。不影响运行，放着先-->
            <script type ="text/javascript" src = "js/registered.js"></script>


            <script>
                var count_particles, stats, update;
                stats = new Stats;
                stats.setMode(0);
                stats.domElement.style.position = 'absolute';
                stats.domElement.style.left = '0px';
                stats.domElement.style.top = '0px';
                document.body.appendChild(stats.domElement);
                count_particles = document.querySelector('.js-count-particles');
                update = function() {
                    stats.begin();
                    stats.end();
                    if (window.pJSDom[0].pJS.particles && window.pJSDom[0].pJS.particles.array) {
                        count_particles.innerText = window.pJSDom[0].pJS.particles.array.length;
                    }
                    requestAnimationFrame(update);
                };
                requestAnimationFrame(update);
            </script>
        </div>
    </div>
</div>
</body>
</html>
