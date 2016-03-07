/**
 * 
 */
$(function(){
	
})
function userEdit(){
	$.ajax({
		type:"post",
		url : "/user/userInfoEdit",
		data : {
			"userId" : $("#userID").val(),
			"name" : $("#userName").val()
		},
		success : function(data) {
			var result = data.result;
			if(data == "success"){
				alert("success")
			}else if(data == "false"){
				alert("false")
			}else if(data == "error"){
				alert("error")
			}
		},
		error:function(data,t){
			console.log("错误"+data+"--"+t);
		}
	});
}