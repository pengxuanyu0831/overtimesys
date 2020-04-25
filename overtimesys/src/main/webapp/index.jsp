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
    <meta charset="UTF-8">
    <title>hello moto</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel ="stylesheet" media="screen" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/bootstrapValidator.css"/>
    <meta http-equiv="X-UA-Compattible" content="IE = edge">
    <meta name = "viewport" content="width=device-width,inital-scale=1">
</head>
<body>

<div class="count-particles">
    <span class="js-count-particles">--</span> particles
</div>
<div id = "particles-js">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <section>
                <div class="col-lg-8 col-lg-offset-2">
                    <div class = "page-header">
                        <h2>Sign up</h2>
                    </div>

                    <section id = "login">
                        <a href = "${pageContext.request.contextPath}/users/findUser">查询用户</a>
                        <hr>
                        <form method="post" action="${pageContext.request.contextPath}/users/insert">
                            <div class = "form-group">
                                <label class="col-lg-3 control-label">用户名:</label>
                                <div class="col-lg-4 ">
                                    <input type = "text" name = "name">
                                </div>
                            </div>

                            <div class = "form-group">
                                <label class="col-lg-3 control-label">密码:</label>
                                <div class="col-lg-4">
                                    <input type = "password" name = "password" placeholder="必须包含数字、字母、符号中的两种">
                                </div>
                            </div>

                            <div class = "form-group">
                                <label class="col-lg-3 control-label">邮箱:</label>
                                <div class="col-lg-4">
                                    <input type = "text" name = "email">
                                </div>
                            </div>
                                <div class = "col-lg-offset-2">
                                    <button type = "submit" class = " btn btn-primary" name = "Registered" >注册</button>
                                </div>
                        </form>
                    </section>
                </div>
             </section>             
        </div>
     </div>
</div>
     <div class="container" style="margin-top: 50px;">
         <div class="row">
             <section>
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class = "page-header">
                        <form method="post" action="${pageContext.request.contextPath}/users/login">
                            <div class = "form-group">
                                <label class ="col-lg-4 control-label">用户名:</label>
                                <div class ="col-lg-5 col-md-5 col-xs-5 col-sm-5 ">
                                    <input type = "text" name = "name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class ="col-lg-4 control-label">密码:</label>
                                <div class ="col-lg-5 col-md-5 col-xs-5 col-sm-5 ">
                                    <input type ="password" name = "password">
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

