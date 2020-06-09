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
    <title>注册</title>

    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" href = "css/bootstrap.min.css"/>
    <!--jQuery -->
    <script type ="text/javascript" src = "js/jquery-3.1.1.min.js"></script>

    <script type ="text/javascript" src = "js/bootstrap.min.js"></script>

    <script type ="text/javascript" src = "js/bootstrapValidator.js"></script>

    <link rel="stylesheet" href = "css/bootstrapValidator.min.css">

    <!-- particles 背景-->
    <link rel ="stylesheet" media="screen" href="css/style.css">

    <!-- sweetalert提示 -->
    <script src = "js/sweetalert2.min.js"></script>
    <link rel ="stylesheet" type = "text/css" href = "css/sweetalert2.min.css">

    <script src="js/particles.min.js"></script>
    <script src ="js/app.js"></script>
    <script src="js/stats.js"></script>

    <!--bootstrap & bootstrapValidator  -->

    <link rel="stylesheet" href = "css/bootstrapValidator.css"/>



<%--    <script src = "${pageContext.request.contextPath}/js/registered.js"></script>--%>
</head>
<body>
<div id = "particles-js">
    <div class="container" style="margin-top: 100px;">
        <div class = "center">
            <form:form modelAttribute="infoModel" method="post"></form:form>
            <form id = "RegisterForm" method="post" name = "RegisterForm" action="${pageContext.request.contextPath}/users/insertUser">
                <div class = "form-group">
                    <div class = row>
                        <from:errors path="*"></from:errors>
                        <label class="col-lg-3 control-label">用户名:</label>
                        <div class="col-md-4 ">
                            <input type = "text" name = "name" class="form-control" placeholder="请输入用户名">
<%--                                   data-bv-notempty--%>
<%--                                   data-bv-notempty-message = "姓名不能为空"--%>
<%--                                   data-bv-stringLength = "true"--%>
<%--                                   data-bv-stringLength-min = 4--%>
<%--                                   data-bv-stringLength-max = 16--%>
<%--                                   data-bv-stringLength-message = "用户名长度限制在4-16位之间">--%>
                            <form:errors path="inputName"></form:errors>
                        </div>
                    </div>
                </div>

                <div class = "form-group">
                    <div class = row>
                        <label class="col-lg-3 control-label">密码:</label>
                        <div class="col-md-4">
                            <input type = "password" name = "password" class="form-control"
                                   placeholder="必须包含数字、字母、符号中的两种"
                                   data-error="密码不能为空" >
                            <div class = "help-block">密码至少包括数字、字母、下划线其中的两种</div>
                            <div class="help-block with-errors"></div>
                            <form:errors path="inputPassword"></form:errors>
                        </div>
                    </div>
                </div>

                <div class = "form-group">
                    <div class = row>
                        <label class="col-lg-3 control-label">邮箱:</label>
                        <div class="col-md-4">
                            <input type = "text" name = "email" class="form-control" placeholder="请输入邮箱地址" >
                            <form:errors path="inputEmail"></form:errors>
                        </div>
                    </div>
                </div>

                <div class = "col-lg-offset-2">
                    <button type = "submit" class = "btn btn-primary" name = "RegisteredBtn" id="RegisteredBtn">注册</button>
                </div>
                <div class = "form-group">
                    <a href="${pageContext.request.contextPath}/index.jsp">去登录</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script>
    $(document).ready(function (){
        // 校验规则
        $('.RegisterForm').bootstrapValidator({
            feedbackIcon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields:{
                'name' :{
                    validators:{
                        notEmpty:{
                            message:'用户名不能为空'
                        },
                        stringLength:{
                            min:4,
                            max:16,
                            message:'用户名长度在4 ~ 16个字符之间'
                        }
                    }
                },
                'email':{
                    validators:{
                        emailAddress:{
                            message:'请输入有效的邮箱格式',
                        },
                        threshold:4,
                        remote:{
                            url:'/users/validatorEmailExist',
                            data:{
                                email:function () {
                                    return$("#email").val()
                                },
                                // email:$('input[email = "email"]').val()
                            },
                            message:"邮箱已存在",
                            delay:2000,
                            type:'POST'
                    }
                    }
                },
                'password':{
                    validators:{
                        notEmpty:{
                            message:'密码不可为空'
                        },
                        stringLength:{
                            min: 4,
                            max: 16,
                            message:'密码长度为4 - 16位之间'
                        },
                        different:{
                            field:'name',
                            message:'用户名和密码不能一致'
                        }
                    }
                }
            }
            });
            $("#RegisteredBtn").click(function () {
                $("RegisterForm").bootstrapValidator('validate');
            }).on('success.form.bv',function () {
            })

            //  .on('success.form.bv',function (e) {
            //     e.preventDefault();
            //     var $form = $(e.target);
            //     var bv = $form.data('bootstrapValidator').validateField('inputName');
            //     $post($form.attr('action',$form.serialize(),function (e) {
            //         $('RegisterForm').bootstrapValidator('disableSubmitButtons',false);
            //     }))
            // })
    });
</script>
</html>
