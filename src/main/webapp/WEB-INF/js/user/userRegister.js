/**
 * 
 */
$(function(){
	getNational("Nationality");
	//getAcademy("Academy");
})
function register() {
	var identityNum = $("#identityNum").val();
	var name = $("#Name").val();
	var email = $("#Email").val();
	if(identityNum==""||identityNum==null||name==""||name==null||email==""||email==null){
		alert("请填写必填项");
		return;
	}
	$.ajax({
		type : "post",
		url : "/user/userRegister",
		data : {
			"identityNum" : $("#identityNum").val(),
			"name":$("#Name").val(),
			"idNumber":$("#idNumber").val(),
			"sex":$("#Sex").find("option:selected").val(),
			"nationality":$("#Nationality").find("option:selected").val(),
			"politicalStatus":$("#politicalStatus").find("option:selected").val(),
			"jobTitle":$("#jobTitle").val(),
			"email":$("#Email").val(),
			"academy":$("#academy").val(),
			"atClass":$("#atClass").val(),
			"majorResearch":$("#majorResearch").val(),
			"address":$("#Address").val(),
			"birthdayString":$("#Birthday").val(),
			"remarks":$("#Remarks").val(),
			"role":$("#Role").find("option:selected").val(),
			"schoolLength":$("#schoolLength").val()
		},
		success : function(data) {
			if (data == "success") {
				alert("添加成功");
				window.location.href = "/user/allUserPage";
			} else if (data == "error") {
				alert("添加失败");
			}
		},
		error : function(error, data) {

		}
	})
}