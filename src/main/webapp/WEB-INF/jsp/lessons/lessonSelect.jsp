<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>全部课程查询</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<script type="text/javascript" src="/web/js/lessons/lessonSelect.js"></script>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
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
								<th>课程类型</th>
								<th>教师姓名</th>
								<th>开课学期</th>
								<th>是否可用</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${AllLessons }" var="lesson">
								<tr>
									<%-- <td>${lesson.classId }&nbsp;</td> --%>
									<td>${lesson.className }</td>
									<td>${lesson.classType }</td>
									<td>${lesson.teacherName }</td>
									<td>${lesson.classYear }</td>
									<c:choose>
										<c:when test="${'0' eq lesson.isEnable}">
											<td>可用</td>
										</c:when>
										<c:otherwise>
											<td>不可用</td>
										</c:otherwise>
									</c:choose>
									<td>
										<shiro:hasRole name="r3">
											<a onclick="checkExist(this)" data-lessonId ="${lesson.classId }" 
												data-teacherId="${lesson.teacherId }" data-studentId="${sessionScope.loginUser.identityNum }"
												data-classYear="${lesson.classYear }" data-teacherName="${lesson.teacherName }"
												data-className="${lesson.className }" data-studentName="${sessionScope.loginUser.name }">选课</a>
										</shiro:hasRole>
										<shiro:hasAnyRoles name="r1,r2">
											<a href="/lesson/lessonUpdate/${lesson.classId }">编辑</a>
											<a onclick="delectIt(this)" value="${lesson.classId }">删除</a>
										</shiro:hasAnyRoles>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>



	</div>
	<!--main-->




	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	<!--footer-->

</body>
</html>
