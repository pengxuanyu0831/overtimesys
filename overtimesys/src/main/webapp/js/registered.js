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
                }
            }
        })

    .on('success.form.bv',function (e) {
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator').validateField('bootstrapValidator');


        $post($form.attr('action',$form.serialize(),function () {
            $('RegisterForm').bootstrapValidator('disableSubmitButtons',false);
        }))
    })

    });