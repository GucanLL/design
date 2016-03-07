/**
 * 
 */
$(function(){
	
})

function userlogin(){
	var identityNum = $("#loginuser").val();
	var password = $("#loginpwd").val();
	if(identityNum == null || identityNum == ""){
		alert("请输入学号")
		return false;
	}
	if(password == null || password == ""){
		alert("请输入密码")
		return false;
	}
	var reg = new RegExp("^[0-9]*$");
	if(!reg.test(identityNum) || identityNum.length != 10){
		alert("学号请输入10位数字")
		return false;
	}
	$.ajax({
	    type : "post",
	    url : "/user/checkLogin",
	    data : {
	      'identityNum' : $("#loginuser").val(),
	      'password' : $("#loginpwd").val()
	    },
	    success : function(data) {
	    	if(data=="success"){
	    		alert("成功")
	    		window.location.href='/user/userEditPage';
	    	}else if(data == "error"){
	    		alert("请核对输入的学号及密码")
	    	}
	    },
	    error:function(data,t){
	    	//alert("错误"+data+"--"+t)
	    	console.log("错误"+data+"--"+t);
	    }
	});
}