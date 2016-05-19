<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息管理——登录页面</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<link href="${ctx }/web/css/login.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/ico" href="/web/images/favicon2.gif">
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>
<script type="text/javascript" src="${ctx }/web/js/login/login.js"></script>
</head>
<body style="background-color:#137fbe; background-repeat:no-repeat; overflow:hidden;">
	
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <ul>
    	<div class="errorMsg">&nbsp;</div>
	    <li><input name="" type="text" class="loginuser" placeholder="学号" id="loginuser"/></li>
	    <li><input name="" type="password" class="loginpwd" placeholder="密码" id="loginpwd"/></li>
	    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="userlogin()"  /><!-- <label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label> --></li>
    </ul>
    
    </div>
    
</body>
</html>