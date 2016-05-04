<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加成绩</title>
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
								<select id="lessonId" name="lessonId" class="form-control">
									<c:forEach items="${lessonInfo }" var="lesson">
										<option value="${lesson.classId }">${lesson.className }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">授课教师：</label>
							<div class="col-sm-5">
								<select id="teacherID" name="teacherID" class="form-control">
									<c:forEach items="${teacherInfo }" var="teacher">
										<option value="${teacher.id }">${teacher.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">学生姓名：</label>
							<div class="col-sm-5">
								<select id="studentId" name="studentId" class="form-control">
									<c:forEach items="${studentInfo }" var="student">
										<option value="${student.id }">${student.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程学年：</label>
							<div class="col-sm-5">
								<select id="classYear" class="form-control">
									<option value="2012-2013（1）">2012-2013（1）</option>
									<option value="2012-2013（2）">2012-2013（2）</option>
									<option value="2013-2014（1）">2013-2014（1）</option>
									<option value="2013-2014（2）">2013-2014（2）</option>
									<option value="2014-2015（1）">2014-2015（1）</option>
									<option value="2014-2015（2）">2014-2015（2）</option>
									<option value="2015-2016（1）">2015-2016（1）</option>
									<option value="2015-2016（2）">2015-2016（2）</option>
									<option value="2016-2017（1）">2016-2017（1）</option>
									<option value="2016-2017（2）">2016-2017（2）</option>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">成绩：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="grade"
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
		function submit(){
			var teacherID=$("#teacherID option:selected").val();
			var teacherName=$("#teacherID option:selected").txt();
			var lessonId = $("#lessonId option:selected").val();
			var lessonName = $("#lessonId option:selected").txt();
			var classYear = $("#classYear").val();
			var studentId = $("#studentId option:selected").val();
			var studentName = $("#studentId option:selected").txt();
			$.ajax({
				type:"post",
				url : "/classes/editClass",
				data : {classId : classId ,classTeacherId:teacherID,classNumber:classNumber},
				success : function(data){
					if(data == "success"){
						alert("成功")
						window.location.href = "/classes/selectAllClassPage"
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