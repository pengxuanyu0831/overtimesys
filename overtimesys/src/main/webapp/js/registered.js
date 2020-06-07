    $(function(){
        // 校验规则
        $('RegisterForm').bootstrapValidator({
            message:"不能为空",
            feedbackIcon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields:{
                'name' :{
                    message:'用户名无效',
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
                            message:'请输入有效的邮箱格式'
                        }
                    }
                },
                'password':{
                    validatros:{
                        notEmpty:{
                            message:'密码不可为空'
                        }

                    }
                }
            },

            submitHandler:function (validator,form,submitButton) {
                var $mail = $("userEmail").val();
                console.log($email);
                $.ajax({url:path + "user/validatorEmailExist",
                    type:'post',
                    async:false,
                    data:{
                    "userEmail":$email
                    },
                    success:function (responseText) {
                    if(responseText == "noEmail"){
                        validator.defaultSubmit();
                        sweetAlert("请到邮箱完成激活")
                    }else {
                        sweetAlert("邮箱已注册")
                    }
                    },
                    error:function () {
                        sweetAlert("系统错误")
                        
                    },

                })
            }
        })

    .on('success.form.bv',function (e) {
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator').validateField('bootstrapValidator');


        $.post($form.attr('action',$form.serialize(),function () {
            $('RegisterForm').bootstrapValidator('disableSubmitButtons',false);
        }))
    })
        })
        // 校验规则的调用。只有写在表单里的规则是起了作用的
        // 校验的是button，所以要写上button的id
        $('#RegisteredBtn').click(function() {
            $('#RegisterForm').bootstrapValidator('validate');
        });

