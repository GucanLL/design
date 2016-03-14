<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
</head>
<body>
<div id="test"></div>
<script type="text/javascript">
$(function(){
	$.ajax({
		type : "post",
		url : "/classes/selectAllClass",
		data : {},
		success : function(data){
			var list = data.list;
			var html = '';
			for(var i in list){
				html += JSON.stringify(list[i]);
				html += '&nbsp;<a href="/classes/editClassPage/'+list[i].classId+'">走起</a>';
				html += '<br/>'
			}
			$("#test").html(html)
		},
		error : function(error){
			alert(error)
		}
	})
})
</script>
</body>
</html>