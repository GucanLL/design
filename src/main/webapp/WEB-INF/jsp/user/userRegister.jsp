<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册测试页</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
</head>
<body>
	姓名：<input type="text" id="name"><br>
	学号/工号 ： <input type="text" id="identityNum"><br>
	密码 : <input type="text" id="password"><br>
	角色 : <input type="text" id="role"><br>
	<button onclick = "submit()">确认</button>
	<script type="text/javascript">
		function submit(){
			$.ajax({
				type : "post",
				url : "/user/userRegister",
				data : {identityNum : $("#identityNum").val(),name : $("#name").val(),password : $("#password").val(),role:$("#role").val()},
				success : function(data){
					if(data == "success"){
						alert("success")
					}else if(data == "error"){
						alert("error")
					}
				},
				error : function(error,data){
					
				}
			})
		}
	</script>
</body>
</html>