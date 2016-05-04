//正则表达式的工具类 author:Andrew
/**
 * 验证是否是身份证号
 * @param card
 * @returns {Boolean}
 */
function isIdentityCardNo(card)  
{  
   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   if(reg.test(card) === false)  
   {     
       return  false;  
   }  
   return true;
} 
/**
 * 匹配邮箱
 * @param email
 * @returns {Boolean}
 */
function isEmail(email){
	var reg=/^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
	 if(reg.test(email) === false)  
	   {     
	       return  false;  
	   }  
	   return true;
}


/**
 * 匹配手机号码
 * @param tel
 * @returns {Boolean}
 */
function isTel(tel){
	var reg=/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
	 if(reg.test(tel) === false)  
	   {     
	       return  false;  
	   }  
	   return true;
}
/**
 * 匹配QQ号
 * @param qq
 * @returns {Boolean}
 */
function isQQ(qq){
	var reg=/^[1-9]\d{4,8}$/;
	 if(reg.test(qq) === false)  
	   {     
	       return  false;  
	   }  
	   return true;
}
/**
 * 匹配正整数
 * @param num
 */
function isNumber(num){
	var reg=/^[0-9]*[1-9][0-9]*$/;
	 
	   return reg.test(num);
}
/**
 * 是否是纯字母
 */
function isLetter(str){
	var reg=/^[a-zA-Z]*$/;
	return reg.test(str);
}
/**
 * 验证是否是字母和数字的组合
 */
function isNumberLetter(str){
	  var reg = /^[0-9a-zA-Z]+$/;
	  return reg.test(str);
}
/**
 * 是否是字符+数字+字符
 * @param str 要验证的字符
 * @author Andrew
 */
function isLetterNumberLetter(str){
	var reg = /^[a-zA-Z]+[0-9]+[a-zA-Z]+$/;
	return reg.test(str);
}
//是否是中
function isMedium(str){
	var mediumRegex = new RegExp("^(?=.{2,})(((?=.*[A-Za-z])(?=.*[0-9]))|(?=.*[A-Za-z])(?=.*\\W)|(?=.*[0-9])(?=.*\\W)).*$", "g");
	return mediumRegex.test(str);
}
//是否是强
function isStrong(str){
	var strongRegex = new RegExp("^(?=.{2,})(?=.*[a-zA-Z])(?=.*[0-9])(?=.*\\W).*$", "g");
	return strongRegex.test(str);
}
