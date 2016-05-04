/**
 * 
 */
$(function(){
	$("#teacherID").val($("#teacherIdHidden").val());
	$("#isEnable").val($("#isEnableHidden").val());
	$("#classYear").val($("#classYearHidden").val());
	$("#lessonType").val($("#lessonTypeHidden").val());
})
function submit() {
	var classId = $("#classId").val();
	var className = $("#name").val();
	var teacherID = $("#teacherID option:selected").val();
	var classYear = $("#classYear option:selected").val();
	var lessonType = $("#lessonType option:selected").val();
	var teacherName = $("#teacherID option:selected").text();
	var isEnable = $("#isEnable option:selected").val();
	$.ajax({
		type : "post",
		url : "/lesson/lessonUpdate",
		data : {
			className : className,
			classId : classId,
			teacherId : teacherID,
			teacherName : teacherName,
			classYear : classYear,
			classType : lessonType,
			isEnable : isEnable
		},
		success : function(data) {
			if (data == "success") {
				alert("成功")
				window.location.href = "/lesson/lessonSelectPage"
			} else {
				alert("失败")
			}

		}
	})
}