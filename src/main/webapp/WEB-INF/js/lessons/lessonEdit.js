/**
 * 
 */
function submit() {
	var className = $("#name").val();
	var teacherID = $("#teacherID option:selected").val();
	var classYear = $("#classYear option:selected").val();
	var lessonType = $("#lessonType option:selected").val();
	var teacherName = $("#teacherID option:selected").text();
	if(className==""||className==null||teacherID==""||teacherID==null||classYear==""||classYear==null
			||lessonType==""||lessonType==null||teacherName==""||teacherName==null){
		alert("请填写全部信息")
		return;
	}
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