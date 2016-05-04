<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<script type="text/javascript" src="/web/js/lessons/lessonUpdate.js"></script>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/ico" href="/web/images/favicon2.gif">
<title>更新课程信息</title>
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
				<div class="col-md-3 row " style="padding-bottom:45px;">
					<div class="ny_zb">

						<jsp:include page="/WEB-INF/jsp/include/left_menu.jsp">
							<jsp:param value="2" name="menuId"/>
						</jsp:include>

					</div>

				</div>
			</div>
		</div>
	</div>
	<!--main-->




	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	<!--footer-->
</body>
</html>