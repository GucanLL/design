/**
 * 
 */
function jump(id) {
	window.location.href = '/user/userUpdate/' + id;
}
function delectIt(obj) {
	var classId = $(obj).attr("value");
	$.ajax({
		type : "post",
		url : "/lesson/delectLesson",
		data : {
			classId : classId
		},
		success : function(data) {
			if (data == "success") {
				alert("成功")
				window.location.reload();
			} else {
				alert("失败")
			}
		}
	})
}
function checkExist(obj){
	var lessonId = $(obj).attr("data-lessonId");
	var studentId = $(obj).attr("data-studentId");
	$.ajax({
		type : "post",
		url : "/score/checkExistLessonStudent",
		data : {
			lessonId : lessonId,
			studentId : studentId
		},
		success : function(data) {
			if (data == "hasExist") {
				alert("您已选择此课程")
			}else if (data == "notExist"){
				selectLesson(obj);
			}
		}
	})
}
function selectLesson(obj){
	var lessonId = $(obj).attr("data-lessonId");
	var teacherId = $(obj).attr("data-teacherId");
	var studentId = $(obj).attr("data-studentId");
	var classYear = $(obj).attr("data-classYear");
	var lessonName = $(obj).attr("data-className");
	var teacherName = $(obj).attr("data-teacherName");
	var studentName = $(obj).attr("data-studentName");
	
	$.ajax({
		type : "post",
		url : "/score/insert",
		data : {
			lessonId : lessonId,
			teacherId : teacherId,
			studentId : studentId,
			lessonYear : classYear,
			lessonName : lessonName,
			teacherName : teacherName,
			studentName : studentName
		},
		success : function(data) {
			if (data == "success") {
				alert("成功")
			} else {
				alert("失败")
			}
		}
	})
}