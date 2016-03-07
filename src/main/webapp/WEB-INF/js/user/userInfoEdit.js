/**
 * 
 */
$(function(){
	userInfo();
})
function userInfo(){
	$.ajax({
		type:"post",
		url : "/user/userInfoSearch",
		data : {
			"userId" : $("#userID").val()
		},
		success : function(data) {
			var result = data.result;
			if(result == "success"){
				var user = data.userInfo;
				$("#identityNum").html(JSON.stringify(user))
				alert("success")
			}else if(result == "false"){
				alert("false")
			}
		},
		error:function(data,t){
			console.log("错误"+data+"--"+t);
		}
	});
}