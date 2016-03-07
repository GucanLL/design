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


<select onchange="loadAllData(this[selectedIndex].value)">
	<option value="">全部</option>
	<option value="2">教师</option>
	<option value="1">学生</option>
</select>
<div id="test"></div>


<script type="text/javascript">
	$(function(){
		loadAllData();
	})
	function loadAllData(role){
		$.ajax({
			type:"post",
			url : "/user/selectAllUser",
			data : {
				role :role
			},
			success : function(data) {
				var html = "";
				for(var i in data.user){
					html += JSON.stringify(data.user[i]);
					html += "<br/>"
				}
				$("#test").html(html);
			},
			error:function(data,t){
				console.log("错误"+data+"--"+t);
			}
		});
	}
</script>

</body>
</html>