<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<!--header-->
	<div class="header">
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
	</div>
	<!--header-->
	<div class="main">
		<div class="container">
			<div class="box">
				<div class="col-md-3 row " style="padding-bottom:45px;">

				</div>
				<div class="col-md-9 design-table-lesson">
					<div class="container-fluid " style="height:370px;padding-top:70px;">
						<div class="row-fluid">
							<div class="span12">
								<div class="hero-unit">
									<h1>
										OOPS! 您的访问受限~
									</h1>
									<p>
										您当前登录的帐号无此权限，请点击下方按钮，回到起始页。
									</p>
									<p>
										<a class="btn btn-primary btn-large" href="/user/welcome">回去啦 »</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	<!--footer-->
</body>
</html>