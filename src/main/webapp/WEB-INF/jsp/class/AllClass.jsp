<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>查询全部班级</title>
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
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<!-- <th>课程ID</th> -->
								<th>班级名称</th>
								<th>教师名称</th>
								<th>班级总人数</th>
								<shiro:hasRole name="r1">
									<th>操作</th>
								</shiro:hasRole>
							</tr>
						</thead>
						<tbody id="classInfo">


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
	selectAllClass();
})
function selectAllClass(){
	$.ajax({
		type : "post",
		url : "/classes/selectAllClass",
		data : {},
		success : function(data){
			var list = data.list;
			var html = '';
			for(var i in list){
				html +='<tr>';
					html +='<td>'+list[i].classId+'</td>';
					html +='<td>'+list[i].classTeacherName+'</td>';
					html +='<td>'+list[i].classNumber+'</td>';
					<shiro:hasRole name="r1">
						html +='<td>';
						html +='<a href="/classes/editClassPage/'+list[i].classId+'">编辑&nbsp;&nbsp;&nbsp;</a>';
						html +='<a onclick="deleteIt('+list[i].classId+')"">删除</a>';
					html +='</td>';
					</shiro:hasRole>
				html +='</tr>';
			}
			$("#classInfo").html(html)
		},
		error : function(error){
			alert(error)
		}
	})
}
function deleteIt(classId){
	alert(classId)
	$.ajax({
		type : "post",
		url : "/classes/delectClass",
		data : {classId:classId},
		success : function(data){
			if(data == "success"){
				alert("成功");
				selectAllClass();
			}else{
				alert("失败")
			}
		},
		error : function(error){
			alert(error)
		}
	})
}
</script>
</body>
</html>