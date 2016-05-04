<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息管理——用户信息查看</title>
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
				<div class="col-md-9">
					<form class="tl-form form-horizontal" id="RegisterForm" style="padding-top: 40px; padding-left: 150px;">
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">学号：</label> <label
									id="identityNum" class="Manager-form-detail">${userInfo.identityNum }</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">姓名：</label> <label
									id="name" class="Manager-form-detail">${userInfo.name }</label>
							</div>
						</div>
						<!-- <div class="form-group">
							<div class="form-group">
								<label class="Manager-form-title">头像：</label> <label
									id="name" class="Manager-form-detail">
<img style="width:100px;" alt="" src="/web/images/red-bea.jpg"></label>
							</div>
						</div> -->
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">身份证号：</label> <label
									id="idNumber" class="Manager-form-detail">${userInfo.idNumber }</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">性别：</label> <label
									id="sex" class="Manager-form-detail">${userInfo.sex }</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">民族：</label> <label
									id="nationality" class="Manager-form-detail">${userInfo.nationality }</label>
							</div>
						</div>
						<!-- 头像      证件照 -->

						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">政治面貌：</label> <label
									id="politicalStatus" class="Manager-form-detail">${userInfo.politicalStatus }</label>
							</div>
						</div>
						<%-- <div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">职称/班委：</label> <label
									id="jobTitle" class="Manager-form-detail">${userInfo.jobTitle }</label>
							</div>
						</div> --%>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">邮箱：</label> <label
									id="email" class="Manager-form-detail">${userInfo.email }</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">班级：</label> <label
									id="atClass" class="Manager-form-detail">${userInfo.atClass }</label>
							</div>
						</div>
						<%-- <div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">研究方向/专业：</label> <label
									id="majorResearch" class="Manager-form-detail">${userInfo.majorResearch }</label>
							</div>
						</div> --%>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">家庭住址：</label> <label
									id="address" class="Manager-form-detail">${userInfo.address }</label>
							</div>
						</div>
						<!-- <div class="form-group has-feedback">
                         <label class="col-sm-2 control-label"><em class="red-star">*</em>入学时间/入职时间：</label>
                              <div class="col-sm-5">
                              	<input type="text" autocomplete="off" id="admissionDate" name="admissionDate" class="form-control" placeholder="">
                                	<span class="form-control-feedback name" aria-hidden="true"></span>
                              </div>
                              <div class="col-md-4">
                              	<div class="errorMsg hint"><span></span></div>
                              </div>
                    </div> -->
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">出生年月：</label> <label
									id="birthday" class="Manager-form-detail">${userInfo.birthday }</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">学制：</label> <label
									id="schoolLength" class="Manager-form-detail">${userInfo.schoolLength }</label>
							</div>
						</div>
						<shiro:hasRole name="r1">
							<div class="form-group has-feedback">
								<div class="form-group">
									<label class="Manager-form-title">角色：</label> <label
											id="role" class="Manager-form-detail">
									<c:choose>
										<c:when test="${userInfo.role eq 'r1' }">
											管理员
										</c:when>
										<c:when test="${userInfo.role eq 'r2' }">
											教师
										</c:when>
										<c:when test="${userInfo.role eq 'r3' }">
											学生
										</c:when>
									</c:choose>
									</label>
								</div>
							</div>
						</shiro:hasRole>
						<div class="form-group has-feedback">
							<div class="form-group">
								<label class="Manager-form-title">备注：</label> <label
									id="remarks" class="Manager-form-detail">${userInfo.remarks }</label>
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