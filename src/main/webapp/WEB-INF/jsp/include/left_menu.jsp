<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
var menuId = '<%=request.getParameter("menuId")%>';
$(function(){
	$("#leftMenu"+menuId).addClass("in");
})
</script>
	
<div class="ny_zbbt">
	<span>功能选项</span>
</div>

<div class="accordion">
	<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-toggle="collapse"
				data-parent="#accordion-827650" href="#leftMenu1">基本设置</a>
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		</div>
		<div id="leftMenu1" class="accordion-body collapse in">
			<shiro:hasRole name="r1">
				<div class="accordion-inner">
					<a href="/user/userRegisterPage">添加用户</a>
				</div>
				<div class="accordion-inner">
					<a href="/user/allUserPage">查看全部用户</a>
				</div>
			</shiro:hasRole>
			<div class="accordion-inner">
				<a href="/user/userInfoPage/${sessionScope.loginUser.identityNum }">个人基本资料查看</a>
			</div>
			<!-- <div class="accordion-inner">
				<a>修改密码</a>
			</div> -->
		</div>
	</div>
	<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-toggle="collapse"
				data-parent="#accordion-827653" href="#leftMenu2">课程管理</a>
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		</div>
		<div id="leftMenu2" class="accordion-body collapse in">
			<div class="accordion-inner">
				<a href="/lesson/lessonSelectPage">全部课程查询</a>
			</div>
			<shiro:hasRole name="r1">
				<div class="accordion-inner">
					<a href="/lesson/lessonEditPage">课程添加</a>
				</div>
			</shiro:hasRole>
		</div>
	</div>
	<shiro:hasRole name="r1">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion-827651" href="#leftMenu3">班级管理</a>
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			</div>
			<div id="leftMenu3" class="accordion-body collapse in">
				<div class="accordion-inner">
					<a href="/classes/addClassPage">添加班级</a>
				</div>
				<div class="accordion-inner">
					<a href="/classes/selectAllClassPage">全部班级</a>
				</div>
			</div>
		</div>
	</shiro:hasRole>
	<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-toggle="collapse"
				data-parent="#accordion-827652" href="#leftMenu4">成绩管理</a>
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		</div>
		<div id="leftMenu4" class="accordion-body collapse in">
			<shiro:hasRole name="r1">
				<div class="accordion-inner">
					<a href="/score/selectAllStudentScorePage">全部成绩查询</a>
				</div>
				<div class="accordion-inner">
					<a href="/score/insertScorePage">导入成绩</a>
				</div>
			</shiro:hasRole>
			<shiro:hasRole name="r2">
				<div class="accordion-inner">
					<a href="/score/selectAllStudentScorePage">全部成绩查询</a>
				</div>
			</shiro:hasRole>
			<shiro:hasRole name="r3">
				<div class="accordion-inner">
					<a href="/score/selectMyScorePage">成绩查询</a>
				</div>
			</shiro:hasRole>
		</div>
	</div>
</div>