<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<script type="text/javascript" src="/web/js/lessons/lessonEdit.js"></script>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/ico" href="/web/images/favicon2.gif">
<title>课程添加</title>
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
					<form class="tl-form form-horizontal" style="padding-top: 40px; padding-left: 150px;">
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程名称：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="name"
									name="name" class="form-control" placeholder="请填写课程名称">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程教师：</label>
							<div class="col-sm-5">
								<select id="teacherID" name="teacherID" class="form-control">
									<c:forEach items="${teacherInfo }" var="teacher">
										<option value="${teacher.identityNum }">${teacher.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">课程类型：</label>
							<div class="col-sm-5">
								<select id="lessonType" class="form-control">
									<option value="必修">必修</option>
									<option value="选修">选修</option>
								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">开课学期：</label>
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
	<!--footer-->
</body>
</html>