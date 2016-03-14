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
班级编号：<input id="classId"><br>
班主任：<select id="teacherID">
		<c:forEach items="${teacherInfo }" var="teacher">
			<option value="${teacher.id }">${teacher.name }</option>
		</c:forEach>
		</select><br>
班级总人数：<input id="classNumber">人<br>
<button onclick="submit()">确认</button>
	<script type="text/javascript">
		function submit(){
			var classId = $("#classId").val();
			var teacherID=$("#teacherID option:selected").val();
			/*  alert(JSON.stringify(teacherID));
			return false;  */
			var classNumber = $("#classNumber").val();
			$.ajax({
				type:"post",
				url : "/classes/addClass",
				data : {classId : classId ,classTeacherId:teacherID,classNumber:classNumber},
				success : function(data){
					if(data == "success"){
						alert("成功")
					}
					if(data == "false"){
						alert("失败")
					}
				}
			})
		}
		
	</script>
</body>
</html>