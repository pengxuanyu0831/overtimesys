<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/4/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="font-size:14px;"><div id="addAdminDialog" class="modal fade" tabindex="-1">
			<div class="modal-dialog cy-modal-dialog-f">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal"><span>×</span></button>
						<h4 class="modal-title" id="myLargeModalLabel">新增管理员</h4>
					</div>
					<div class="modal-body">
						<form id="addAdminForm" method="post" action="${ctx}/admin/operator/add.htm" class="form-horizontal">
							<div class="form-group">
								<label class="form-label text-bold" for="">登录名</label>
								<input class="form-control" placeholder="" type="text" name="loginName" id="addLoginName"/>
							</div>
							<div class="form-group">
								<label class="form-label text-bold" for="">用户名</label>
								<input class="form-control" placeholder="" type="text" name="userName" id="addUserName" />
							</div>
							<div class="form-group">
								<label class="form-label text-bold" for="">密码</label>
								<input class="form-control" placeholder="" type="password" name="password" id="addPassword" />
							</div>
							<div class="form-group">
								<label class="form-label text-bold" for="">角色</label>
								<div class="form-group">
									<div class="col-md-10 col-xs-10">
										<div class="checkbox cy-nopadding" id="addRoles">
											<c:forEach var="role" items="${roles}">
                                                <label name="addRoleLabel" class="form-checkbox form-icon form-text"><input type="checkbox" id="addRole_${role.id}" name="roles" value="${role.id}"> ${role.roleName}</label>
                                            </c:forEach>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
                    <!--Modal footer-->
					<div class="modal-footer">
						<button class="btn btn-primary" οnclick="addAdmin();">确定</button>
						<button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
					</div>
				</div>
			</div>
		</div></span>
</body>
</html>


===========================================================

<script type ="text/javascript">
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

	});
</script>