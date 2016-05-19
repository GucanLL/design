<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>编辑成绩</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<script type="text/javascript" src="/web/js/lessons/lessonUpdate.js"></script>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/ico" href="/web/images/favicon2.gif">
</head>
<body>
<div class="header">
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</div>
	<!--header-->



	<div class="main">
		<div class="container">
			<div class="box">
				<div class="col-md-3 row " style="padding-bottom:45px;">
					<div class="ny_zb">

						<jsp:include page="/WEB-INF/jsp/include/left_menu.jsp">
							<jsp:param value="2" name="menuId"/>
						</jsp:include>

					</div>

				</div>
				<input type="hidden" id="scoreId" value="${scoreId }">
				<div class="col-md-9 design-table-lesson">
					<form class="tl-form form-horizontal" style="padding-top: 40px; padding-left: 100px;">
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程名称：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="lessonName"
									name="lessonName" class="form-control" disabled="disabled">
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">授课教师：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="teacherID"
									name="teacherID" class="form-control" disabled="disabled">
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">学号：</label>
							<div class="col-sm-5">
								<input type="hidden" id="studentId">
								<input type="text" autocomplete="off" id="studentName"
									name="studentName" class="form-control" disabled="disabled">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程学年：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="classYear"
									name="classYear" class="form-control" disabled="disabled">
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">成绩：</label>
							<div class="col-sm-5">
								<input type="number" autocomplete="off" id="grade"
									name="grade" class="form-control" placeholder="请填写成绩">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-5">
								<a class="btn red-btn submit-button" onclick="submit()">确定</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--main-->




	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>

	<script type="text/javascript">
		$(function(){
			reloadData();
		})
		function reloadData(){
			var scoreId = $("#scoreId").val();
			$.ajax({
				type:"post",
				url : "/score/selcetScoreById",
				data : {id : scoreId},
				success : function(data){
					var scoreInfo = data.scoreInfo;
					$("#teacherID").val(scoreInfo.teacherName);
					$("#lessonName").val(scoreInfo.lessonName);
					$("#studentId").val(scoreInfo.studentId);
					$("#studentName").val(scoreInfo.studentId);
					$("#classYear").val(scoreInfo.lessonYear);
					$("#grade").val(scoreInfo.grade);
				}
			})
		}
		function submit(){
			var id = $("#scoreId").val();
			var grade = $("#grade").val();
			if(grade == ""|| grade == null){
				alert("请填写成绩");
				return;
			}
			$.ajax({
				type:"post",
				url : "/score/updateScore",
				data : {id:id,grade:grade},
				success : function(data){
					if(data == "success"){
						alert("成功")
						window.location.href = "/score/selectAllStudentScorePage"
					}
					if(data == "false"){
						alert("失败")
					}
				}
			})
		}
		
	</script>
</body>
</html>