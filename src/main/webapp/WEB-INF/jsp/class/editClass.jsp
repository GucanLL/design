<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>编辑班级信息</title>
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
				<div class="col-md-9 design-table-lesson">
					<form class="tl-form form-horizontal" style="padding-top: 40px; padding-left: 100px;">
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">班级编号：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="classId"
									name="classId" class="form-control" placeholder="请填写课程名称" value="${classId }">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">班主任：</label>
							<div class="col-sm-5">
								<select id="teacherID" name="teacherID" class="form-control">
									<c:forEach items="${teacherInfo }" var="teacher">
										<option value="${teacher.identityNum }">${teacher.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">班级总人数：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="classNumber"
									name="classNumber" class="form-control" placeholder="请填写班级总人数">
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
			var classId = $("#classId").val();
			$.ajax({
				type:"post",
				url : "/classes/selectClass",
				data : {classId : classId},
				success : function(data){
					var classInfo = data.classInfo;
					$("#teacherID").val(classInfo.classTeacherId);
					$("#classNumber").val(classInfo.classNumber);
				}
			})
		}
		function submit(){
			var classId = $("#classId").val();
			var teacherID=$("#teacherID option:selected").val();
			/*  alert(JSON.stringify(teacherID));
			return false;  */
			var classNumber = $("#classNumber").val();
			if(classId==""||classId==null||teacherID==""||teacherID==null||classNumber==""||classNumber==null){
				alert("请填写全部信息")
				return;
			}
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