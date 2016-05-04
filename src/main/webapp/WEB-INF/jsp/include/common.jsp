<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link href="${ctx}/web/resources/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/web/resources/lib/bootstrap/dist/css/bootstrap-theme.css" rel="stylesheet">
<script src="${ctx}/web/resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${ctx}/web/resources/lib/bootstrap/dist/js/bootstrap.js"></script>
<!-- 表单验证 -->
<script src="${ctx}/web/resources/lib/jquery-validation/dist/jquery.validate.min.js"></script>
<link href="${ctx}/web/resources/lib/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" rel="stylesheet">
<link href="${ctx}/web/resources/lib/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js" rel="stylesheet">
<script src="${ctx}/web/js/util/userUtils.js"></script>
<script src="${ctx}/web/js/util/RegexUtil.js"></script>