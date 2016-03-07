<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/WEB-INF/jsp/include/common.jsp" %>
<title>Insert title here</title>
</head>
<body>
	课程名称<input type="text" id="name">
	
	教师<select id="teacherID">
		<c:forEach items="${teacherInfo }" var="teacher">
			<option value="${teacher.id }">${teacher.name }</option>
		</c:forEach>
		<option value="5555">111111111</option>
		</select>
	开课学期<select id="classYear">
	<option>111111111</option>
	</select>
	<button onclick="submit()">确认</button>
	<script type="text/javascript">
		function submit(){
			var className = $("#name").val();
			var teacherID=$("#teacherID option:selected").val();
			/*  alert(JSON.stringify(teacherID));
			return false;  */
			var classYear = $("#classYear").val();
			$.ajax({
				type:"post",
				url : "/lesson/lessonEdit",
				data : {className : className ,teacherId:teacherID,classYear:classYear,type:"0"},
				success : function(data){
					if(data == "success"){
						alert("成功")
					}
					if(data == "error"){
						alert("失败")
					}
				}
			})
		}
		
	</script>
</body>
</html>