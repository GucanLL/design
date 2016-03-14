<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<title>查看课程</title>
</head>
<body>
	<table>
		<c:forEach items="${AllLessons }" var="lesson" >
			<tr>
				<td>${lesson.classId }&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>${lesson.className }&nbsp;&nbsp;&nbsp;</td>
				<td>${lesson.classType }&nbsp;&nbsp;&nbsp;</td>
				<td>${lesson.teacherId }&nbsp;&nbsp;&nbsp;</td>
				<td>${lesson.classYear }&nbsp;&nbsp;&nbsp;</td>
				<td>${lesson.isEnable }&nbsp;&nbsp;&nbsp;</td>
				<td>
					<a href="/lesson/lessonUpdate/${lesson.classId }">编辑</a>
					<a onclick="delectIt(this)" value="${lesson.classId }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		function jump(id){
			window.location.href='/user/userUpdate/'+id;
		}
		function delectIt(obj){
			var classId = $(obj).attr("value");
			$.ajax({
				type:"post",
				url : "/lesson/delectLesson",
				data : {classId:classId},
				success : function(data){
					if(data == "success"){
						alert("成功")
						 window.location.reload();
					}else{
						alert("失败")
					}
				}
			})
		}
	</script>
</body>
</html>