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
	/*if(className==""||className==null||teacherID==""||teacherID=="-1"||classYear==""||classYear==null
			||lessonType==""||lessonType==null||teacherName==""||teacherName==null
			||classId==""||classId==null||isEnable==""||isEnable==null){
		alert("请填写全部信息")
		return;
	}*/
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
			if(data == "success"){
				alert("成功")
				window.location.href = "/lesson/lessonSelectPage"
			}else{
				alert("失败")
			}

		}
	})
}