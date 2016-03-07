<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息管理——用户信息编辑</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<script type="text/javascript" src="${ctx }/web/js/user/userAdd.js"></script>
</head>
<body>
<input type="hidden" value="${userID }" id="userID">
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<label>姓名：</label><input type="text" id="userName"><br>
<button type="submit" onclick="userEdit()">确认</button>
<div id ="test"></div>
</body> 
</html>