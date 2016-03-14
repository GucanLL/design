package math.design.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;

import math.design.base.mapper.BaseUserMapper;
import math.design.base.model.BaseUser;
import math.design.base.model.LoginUser;
import math.design.base.service.UserService;
import math.design.util.MD5Util;
import math.design.util.UUIDGenerator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request){
		return "login/login";
	}
	/*
	 * 登录
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public String checkLogin(HttpServletRequest request,LoginUser user,boolean rememberMe){
		LoginUser lu = new LoginUser();
		MD5Util md5=new MD5Util();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		return userService.loginController(user,rememberMe);
	}
	@RequestMapping(value = "/userRegisterPage", method = RequestMethod.GET)
	public String userRegisterPage(HttpServletRequest request){
		return "user/userRegister";
	}
	/*
	 * 用户注册
	 */
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ResponseBody
	public String userRegister(HttpServletRequest request,BaseUser user){
		MD5Util md5=new MD5Util();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		user.setId(UUIDGenerator.getUUID());
		int result = userService.insertSelective(user);
		if(result>0){
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setUsername(user.getIdentityNum());
			token.setPassword(user.getPassword().toCharArray());
			try {
				SecurityUtils.getSubject().login(token);
				return "success";
			} catch (AuthenticationException e) {//登陆失败
				//如果登陆失败销毁session
				Subject currentUser = SecurityUtils.getSubject();
	    		Session session = currentUser.getSession();
	    		session.removeAttribute("loginUser");
				System.out.println(e.getMessage());
				if(e.getMessage() == "usererror"){//用户不存在
					return "usererror";
				}
				return "error";//用户密码错误
			}
		}else{
			return "error";
		}
	}
	
	/*
	 * 跳转用户页
	 */
	@RequestMapping(value = "/allUserPage", method = RequestMethod.GET)
	public String allUserPage(HttpServletRequest request){
		return "user/allUserSelect";
	}
	
	/*
	 * 查询全部用户
	 */
	@RequestMapping(value = "/selectAllUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectAllUser(HttpServletRequest request,String role){
		Map<String,Object> map = new HashMap<String, Object>();
		List<BaseUser> list;
		if(role != null && role != ""){
			list = userService.selectUserByRole(role);
		}else{
			list = userService.selectAllUser();
		}
		map.put("user", list);
		return map;
	}
	
	/*
	 * 跳转用户信息编辑页
	 */
	@RequestMapping(value = "/userInfoEditPage/{userId}", method = RequestMethod.GET)
	public ModelAndView userInfoPage(HttpServletRequest request ,@PathVariable String userId){
		ModelAndView m = new ModelAndView("user/userInfoEdit");
		return m;
	}
	
	/*
	 * 查询用户信息
	 */
	@RequestMapping(value = "/userInfoSearch", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userInfoSelect(HttpServletRequest request,String userId){
		Map<String,Object> m = new HashMap<String, Object>();
		if(userId!=null&&userId!=""){
			BaseUser user = userService.selectByPrimaryKey(userId);
			m.put("userInfo", user);
			m.put("result", "success");
		}else{
			m.put("result", "false");
		}
		return m;
	}
	
	/*
	 * 跳转用户信息添加页面
	 */
	@RequestMapping(value = "/userAddPage", method = RequestMethod.GET)
	public ModelAndView userEditPage(HttpServletRequest request){
		LoginUser lu = (LoginUser) request.getSession().getAttribute("loginUser");
		ModelAndView m = new ModelAndView("user/userAdd");
		if(null!=lu){
			m.addObject("userID", lu.getId());
		}
		return m;
	}
	/*
	 * 添加用户基本信息编辑
	 */
	@RequestMapping(value = "/userInfoAdd", method = RequestMethod.POST)
	@ResponseBody
	public String userInfoEdit(HttpServletRequest request,BaseUser user,String userId){
		int result = userService.insertSelective(user);
		if(result > 0){
			return "success";
		}else{
			return "false";
		}
	}
	
	@RequestMapping(value = "/testModel", method = RequestMethod.GET)
	public String testModel(HttpServletRequest request){
		return "/model";
	}
	
}
