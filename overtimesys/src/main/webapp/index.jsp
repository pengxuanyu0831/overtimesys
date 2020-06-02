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
    <script src = "js/sweetalert.js"></script>
    <link rel ="stylesheet" type = "text/css" href = "css/sweetalert.css">

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
                        <h2>Sign in</h2>
                    </div>
                    <div id = "login">
                        <a href = "${pageContext.request.contextPath}/users/findUser">查询用户</a>
                        <hr>


                        <div>
                            <a href = "${pageContext.request.contextPath}/toRegister.jsp">注 册</a>
                        </div>
                        <%--@elvariable id="infoModel" type="com"--%>
<%--                        <form:form modelAttribute="infoModel" method="post"></form:form>--%>
<%--                        <form id = "RegisterForm" method="post" name = "RegisterForm" action="${pageContext.request.contextPath}/users/insert">--%>
<%--                            <div class = "form-group">--%>
<%--                                <from:errors path="*"></from:errors>--%>
<%--                                <label class="col-lg-3 control-label">用户名:</label>--%>
<%--                                <div class="col-lg-4 ">--%>
<%--                                    <input type = "text" name = "name" placeholder="请输入用户名"--%>
<%--                                    data-bv-notempty--%>
<%--                                    data-bv-notempty-message = "姓名不能为空"--%>
<%--                                    data-bv-stringLength = "true"--%>
<%--                                           data-bv-stringLength-min = 4--%>
<%--                                           data-bv-stringLength-max = 16--%>
<%--                                           data-bv-stringLength-message = "用户名长度限制在4-16位之间">--%>
<%--                                    <form:errors path="name"></form:errors>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class = "form-group">--%>
<%--                                <label class="col-lg-3 control-label">密码:</label>--%>
<%--                                <div class="col-lg-4">--%>
<%--                                    <input type = "password" name = "password" placeholder="必须包含数字、字母、符号中的两种">--%>
<%--                                    <form:errors path="pasword"></form:errors>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class = "form-group">--%>
<%--                                <label class="col-lg-3 control-label">邮箱:</label>--%>
<%--                                <div class="col-lg-4">--%>
<%--                                    <input type = "text" name = "email" placeholder="请输入邮箱地址"--%>
<%--                                    data-bv-emailAddress = "true"--%>
<%--                                    data-bv-emailAddress-message = "请输入正确格式的邮箱地址">--%>
<%--                                    <form:errors path="email"></form:errors>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class = "col-lg-offset-2">--%>
<%--                                <button type = "submit" class = " btn btn-primary" name = "Registered" id="RegisteredBtn">注册</button>--%>
<%--                            </div>--%>
<%--                        </form>--%>
                        <hr>

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
<%--<script>--%>
<%--    $(function(){--%>
<%--        // 校验规则--%>
<%--        //这一串校验规则也无效，只有之间写在form里的规则是生效的，原因暂时不清楚，先放在这--%>
<%--        $('RegisterForm').bootstrapValidator({--%>
<%--            message:"不能为空",--%>
<%--            feedbackIcon: {--%>
<%--                valid: 'glyphicon glyphicon-ok',--%>
<%--                invalid: 'glyphicon glyphicon-remove',--%>
<%--                validating: 'glyphicon glyphicon-refresh'--%>
<%--            },--%>
<%--            fields:{--%>
<%--                'name' :{--%>
<%--                    message:'用户名无效',--%>
<%--                    validators:{--%>
<%--                        notEmpty:{--%>
<%--                            message:'用户名不能为空'--%>
<%--                        },--%>
<%--                        stringLength:{--%>
<%--                            min:4,--%>
<%--                            max:16,--%>
<%--                            message:'用户名长度在4 ~ 16个字符之间'--%>
<%--                        }--%>
<%--                    }--%>
<%--                },--%>
<%--                'email':{--%>
<%--                    validators:{--%>
<%--                        emailAddress:{--%>
<%--                            message:'请输入有效的邮箱格式'--%>
<%--                        }--%>
<%--                    }--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>

<%--    });--%>



<%--            .on('success.form.bv',function (e) {--%>
<%--                e.preventDefault();--%>
<%--                var $form = $(e.target);--%>
<%--                var bv = $form.data('bootstrapValidator').validateField('name');--%>


<%--                $post($form.attr('action',$form.serialize(),function (e) {--%>
<%--                    $('RegisterForm').bootstrapValidator('disableSubmitButtons',false);--%>
<%--                }))--%>
<%--            })--%>

<%--    });--%>
</body>
</html>
