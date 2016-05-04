<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>查询全部用户</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx }/web/js/user/userRegister.js"></script>
<link rel="shortcut icon" type="image/ico" href="/web/images/favicon2.gif">
</head>
<body>
<!--导航条-->
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</div>
	<!--header-->



	<div class="main">
		<div class="container">
			<div class="box">
				<div class="col-md-3 row ">
					<div class="ny_zb">

						<jsp:include page="/WEB-INF/jsp/include/left_menu.jsp"></jsp:include>

					</div>

				</div>
				<div class="col-md-9 design-table-lesson">
					<div>
						<h2>筛选条件</h2>
						<div class="col-md-5">
							<select onchange="loadAllData(this[selectedIndex].value)" class="form-control">
								<option value="">全部</option>
								<option value="r1">管理员</option>
								<option value="r2">教师</option>
								<option value="r3">学生</option>
							</select>
						</div>
						<br>
						<br>
					</div>
					
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>学号/工号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>民族</th>
								<th>政治面貌</th>
								<th>邮箱</th>
								<th>身份</th>
								<shiro:hasRole name="r1">
									<th>操作</th>
								</shiro:hasRole>
							</tr>
						</thead>
						<tbody id="userInfo">
								

						</tbody>
					</table>

				</div>
			</div>
		</div>



	</div>
	<!--main-->




	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	<!--footer-->

<script type="text/javascript">
$(function(){
	loadAllData();
})
function loadAllData(role){
	$.ajax({
		type:"post",
		url : "/user/selectAllUser",
		data : {
			role :role
		},
		success : function(data) {
			var html = "";
			var list = data.user;
			for(var i in data.user){
				if(list[i].role == "r1"){
					list[i].role = "管理员";
				}else if(list[i].role == "r2"){
					list[i].role = "教师";
				}else if(list[i].role == "r3"){
					list[i].role = "学生";
				}
				html +='<tr>';
				html +='<td>'+list[i].identityNum+'</td>';
				html +='<td>'+list[i].name+'</td>';
				html +='<td>'+list[i].sex+'</td>';
				html +='<td>'+list[i].email+'</td>';
				html +='<td>'+list[i].nationality+'</td>';
				html +='<td>'+list[i].politicalStatus+'</td>';
				html +='<td>'+list[i].role+'</td>';
				<shiro:hasRole name="r1">
					html +='<td>';
						html +='<a href="/user/userInfoEditPage/'+list[i].identityNum+'">编辑&nbsp;&nbsp;</a>';
						html +='<a onclick="deleteIt('+list[i].identityNum+')"">&nbsp;删除</a>';
					html +='</td>';
				</shiro:hasRole>
			html +='</tr>';
			}
			$("#userInfo").html(html);
		},
		error:function(data,t){
			console.log("错误"+data+"--"+t);
		}
	});
}
</script>
</body>
</html>