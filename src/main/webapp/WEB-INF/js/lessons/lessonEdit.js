/**
 * 
 */
function submit() {
	var className = $("#name").val();
	var teacherID = $("#teacherID option:selected").val();
	var classYear = $("#classYear option:selected").val();
	var lessonType = $("#lessonType option:selected").val();
	var teacherName = $("#teacherID option:selected").text();
	$.ajax({
		type : "post",
		url : "/lesson/lessonEdit",
		data : {
			className : className,
			teacherId : teacherID,
			teacherName : teacherName,
			classYear : classYear,
			classType : lessonType
		},
		success : function(data) {
			if (data == "success") {
				alert("成功")
				window.location.href = "/lesson/lessonSelectPage"
			}
			if (data == "error") {
				alert("失败")
			}
		}
	})
}