/**
 * 56个民族
 */
function getNational(id){
	var national = [
	                "汉族", "壮族", "满族", "回族", "苗族", "维吾尔族", "土家族", "彝族", "蒙古族", "藏族", "布依族", "侗族", "瑶族", "朝鲜族", "白族", "哈尼族",
	                "哈萨克族", "黎族", "傣族", "畲族", "傈僳族", "仡佬族", "东乡族", "高山族", "拉祜族", "水族", "佤族", "纳西族", "羌族", "土族", "仫佬族", "锡伯族",
	                "柯尔克孜族", "达斡尔族", "景颇族", "毛南族", "撒拉族", "布朗族", "塔吉克族", "阿昌族", "普米族", "鄂温克族", "怒族", "京族", "基诺族", "德昂族", "保安族",
	                "俄罗斯族", "裕固族", "乌孜别克族", "门巴族", "鄂伦春族", "独龙族", "塔塔尔族", "赫哲族", "珞巴族"
	        ];
	        window.onload = function ()
	        {
	            var nat = document.getElementById (id);
	            for ( var i = 0; i < national.length; i++)
	            {
	                var option = document.createElement ('option');
	                option.value = national[i];
	                var txt = document.createTextNode (national[i]);
	                option.appendChild (txt);
	                nat.appendChild (option);
	            }
	        }
}
/**
 * 学院
 */
/*function getAcademy(id){
	var national = [
	                "数学科学学院","文学院"
	        ];
	        window.onload = function ()
	        {
	            var nat = document.getElementById (id);
	            for ( var i = 0; i < national.length; i++)
	            {
	                var option = document.createElement ('option');
	                option.value = i;
	                var txt = document.createTextNode (national[i]);
	                option.appendChild (txt);
	                nat.appendChild (option);
	            }
	        }
}*/
/**
 * 时间格式转换公共方法
 */

Date.prototype.Format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}