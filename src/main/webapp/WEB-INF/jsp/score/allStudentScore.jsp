<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>查询成绩</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
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
								<th>课程名称</th>
								<th>教师姓名</th>
								<th>学号</th>
								<th>课程学年</th>
								<th>成绩</th>
								<shiro:hasAnyRoles name="r1,r2">
									<th>操作</th>
								</shiro:hasAnyRoles>
							</tr>
						</thead>
						<tbody id="allScore">

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
	selectAllStudentScore();
})
function selectAllStudentScore(){
	$.ajax({
		type : "post",
		url : "/score/selectAllStudentScore",
		data : {},
		success : function(data){
			var list = data.scoreList;
			var html = '';
			for(var i in list){
				if(list[i].grade==null){
					list[i].grade ="";
				}
				html +='<tr>';
					html +='<td>'+list[i].lessonName+'</td>';
					html +='<td>'+list[i].teacherName+'</td>';
					html +='<td>'+list[i].studentName+'</td>';
					html +='<td>'+list[i].lessonYear+'</td>';
					html +='<td>'+list[i].grade+'</td>';
					<shiro:hasAnyRoles name="r1,r2">
						html +='<td>';
						html +='<a href="/score/editScorePage/'+list[i].id+'">编辑&nbsp;&nbsp;&nbsp;</a>';
						html +='<a onclick="deleteIt("'+list[i].id+'")"">删除</a>';
					html +='</td>';
					</shiro:hasAnyRoles>
					
				html +='</tr>';
			}
			$("#allScore").html(html)
		},
		error : function(error){
			alert(error)
		}
	})
}
function deleteIt(scoreId){
	alert(scoreId)
	$.ajax({
		type : "post",
		url : "/score/deleteScore",
		data : {id:scoreId},
		success : function(data){
			if(data == "success"){
				alert("成功");
				selectAllStudentScore();
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