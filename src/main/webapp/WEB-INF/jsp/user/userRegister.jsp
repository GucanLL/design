<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  --%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息管理——用户信息</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<link href="${ctx }/web/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctx }/web/js/user/userRegister.js"></script>
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

						<jsp:include page="/WEB-INF/jsp/include/left_menu.jsp">
							<jsp:param value="1" name="menuId"/>
						</jsp:include>

					</div>

				</div>
				<div class="col-md-9">
					<form class="tl-form form-horizontal" id="RegisterForm"
						style="padding-top: 40px; padding-left: 150px;">
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>学号/工号：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="identityNum"
									name="identityNum" class="form-control" placeholder="">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>姓名：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="Name" name="Name"
									class="form-control" placeholder=""> <span
									class="form-control-feedback name1" aria-hidden="true"></span>
							</div>
							<div class="col-sm-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>身份证号：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="idNumber"
									name="idNumber" class="form-control" placeholder=""> <span
									class="form-control-feedback name1" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>性别：</label>
							<div class="col-sm-5">
								<select id="Sex" name="Sex" class="form-control">
									<option value="-1">请选择</option>
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
								<!-- <input type="text" autocomplete="off" id="Sex" name="Sex" class="form-control" placeholder="">
                                	<span class="form-control-feedback name" aria-hidden="true"></span> -->
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>民族：</label>
							<div class="col-sm-5">
								<select id="Nationality" name="Nationality" class="form-control"></select>
								<!-- <input type="text" autocomplete="off" id="Nationality" name="Nationality" class="form-control" placeholder="">
                                	<span class="form-control-feedback name" aria-hidden="true"></span> -->
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<!-- 头像      证件照 -->

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>政治面貌：</label>
							<div class="col-sm-5">
								<select id="politicalStatus" name="politicalStatus"
									class="form-control">
									<option value="群众">群众</option>
									<option value="团员">团员</option>
									<option value="中共预备党员">中共预备党员</option>
									<option value="中共党员">中共党员</option>
									<option value="其他">其他</option>
								</select>
								<!-- <input type="text" autocomplete="off" id="politicalStatus" name="politicalStatus" class="form-control" placeholder="">
                                	<span class="form-control-feedback name" aria-hidden="true"></span> -->
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<!-- <div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>职称/班委：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="jobTitle"
									name="jobTitle" class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div> -->
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>邮箱：</label>
							<div class="col-sm-5">
								<input type="email" autocomplete="off" id="Email" name="Email"
									class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>班级：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="atClass"
									name="atClass" class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<!-- <div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>研究方向/专业：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="majorResearch"
									name="majorResearch" class="form-control" placeholder="">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div> -->
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>家庭住址：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="Address"
									name="Address" class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>出生年月：</label>
							<div class="col-sm-5">
								<input type="date" autocomplete="off" id="Birthday"
									name="Birthday" class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>学制：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="schoolLength"
									name="schoolLength" class="form-control" placeholder="">
								<span class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>身份：</label>
							<div class="col-sm-5">
								<shiro:hasRole name="r1">
									<select id="Role" name="Role" class="form-control">
										<option value="r3">学生</option>
										<option value="r2">教师</option>
										<option value="r1">管理员</option>
									</select>
								</shiro:hasRole>
								<shiro:hasAnyRoles name="r2,r3">
									<input id="Role" disabled="disabled" class="form-control">
								</shiro:hasAnyRoles>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label"><em
								class="red-star">*</em>备注：</label>
							<div class="col-sm-5">
								<input type="text" autocomplete="off" id="Remarks"
									name="Remarks" class="form-control" placeholder=""> <span
									class="form-control-feedback name" aria-hidden="true"></span>
							</div>
							<div class="col-md-4">
								<div class="errorMsg hint">
									<span></span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-5">
								<button type="button" onclick="register()"
									class="btn red-btn submit-button" style="margin-left: 20px;">确定</button>
								<button class="btn red-btn submit-button"
									style="margin-left: 130px;">取消</button>
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