package math.design.base.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import math.design.base.model.BaseClass;
import math.design.base.model.BaseUser;
import math.design.base.model.LoginUser;
import math.design.base.service.ClassService;
import math.design.base.service.UserService;
import math.design.util.MD5Util;
import math.design.util.UUIDGenerator;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import math.design.util.MailSenderInfo;
import math.design.util.SimpleMailSender;

@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClassService classService;
	
	@Value("${math.send.mail.userName}")
	private String mailUserName;
	@Value("${math.send.mail.code}")
	private String mailPassword;
	@Value("${math.send.mail.subject}")
	private String subject;
	@Value("${math.send.mail.mailServerHost}")
	private String mailServerHost;
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request){
		return "login/login";
	}
	/**
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
	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ResponseBody
	public String userRegister(HttpServletRequest request,BaseUser user){
		/*自动生成6位数的密码*/
		Random random = new Random();
		int x = random.nextInt(899999)+100000;
		String p = Integer.toString(x);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		if(user.getBirthdayString()!=null){
			try {
				user.setBirthday(sdf.parse(user.getBirthdayString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*密码加密*/
		MD5Util md5=new MD5Util();
		user.setPassword(md5.getMD5ofStr(p));
		
		user.setId(UUIDGenerator.getUUID());
		user.setLastModifyTime(new Date());
		int result = userService.insertSelective(user);
		if(result>0){
			/*UsernamePasswordToken token = new UsernamePasswordToken();
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
			}*/
			/*StringBuffer content = new StringBuffer();
			content.append("<p><strong>邮件标题：</strong>通力平台 – 邮箱激活</p>");
			content.append("<p><strong>邮件内容：</strong></p>");
			content.append("<p>如果您无法直接点击上面链接访问，请将链接复制到浏览器地址栏进行访问。</p>");
			content.append("<p>为保障您的帐号安全，请在24小时内点击该链接。若您没有申请过验证邮箱 ，请您忽略此邮件，由此给您带来的不便请谅解。</p>");
			content.append("<p>本邮件为系统邮件，请勿直接回复，谢谢。</p>");
			
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost(mailServerHost);
			mailInfo.setValidate(true);
			mailInfo.setUserName(mailUserName);
			mailInfo.setPassword(mailPassword);
			mailInfo.setFromAddress(mailUserName);
			mailInfo.setSubject(subject);
			
			mailInfo.setToAddress("296232480@qq.com");
			mailInfo.setContent(content.toString());
			//这个类主要来发送邮件
			SimpleMailSender sms = new SimpleMailSender(); 
			sms.sendHtmlMail(mailInfo);*/
			return "success";
		}else{
			return "error";
		}
	}
	
	/**
	 * 跳转全部用户页
	 */
	@RequestMapping(value = "/allUserPage", method = RequestMethod.GET)
	public String allUserPage(HttpServletRequest request){
		return "user/allUserSelect";
	}
	
	/**
	 * 查询全部用户
	 */
	@RequestMapping(value = "/selectAllUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectAllUser(HttpServletRequest request,String role){
		Map<String,Object> map = new HashMap<String, Object>();
		List<BaseUser> list;
		BaseUser user = new BaseUser();
		if(role != null && role != ""){
			user.setRole(role);
			list = userService.selectUserIf(user);
		}else{
			list = userService.selectUserIf(user);
		}
		map.put("user", list);
		return map;
	}
	
	/**
	 * 跳转用户信息编辑页
	 */
	@RequestMapping(value = "/userInfoEditPage/{userId}", method = RequestMethod.GET)
	public ModelAndView userInfoPage(HttpServletRequest request ,@PathVariable String userId){
		ModelAndView m = new ModelAndView("user/userInfoEdit");
		List<BaseClass> list = classService.selectAll();
		m.addObject("classInfo", list);
		return m;
	}
	
	/**
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
	
	/**
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
	/**
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
	
	/**
	 * 按照班级查找学生
	 */
	@RequestMapping(value = "/updateUserInfo/{userId}", method = RequestMethod.GET)
	public ModelAndView selectClassStudentPage(HttpServletRequest request ,@PathVariable String userId){
		ModelAndView m = new ModelAndView("user/userInfoEdit");
		m.addObject("userId", userId);
		return m;
	}
	
	/**
	 * 学生信息显示页面
	 */
	@RequestMapping(value = "/userInfoPage/{studentId}", method = RequestMethod.GET)
	public String selectClassStudentPage(HttpServletRequest request ,@PathVariable String studentId , Model model){
		BaseUser user = userService.selectByIdentityNum(studentId);
		model.addAttribute("userInfo", user);
		return "user/userInfo";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String testModel(HttpServletRequest request){
		return "util/welcome";
	}
	@RequestMapping(value = "/loginOut",method = RequestMethod.GET)
	public String loginOut(HttpSession session){
		String logoutDisable = (String)session.getAttribute("logoutDisable");
		SecurityUtils.getSubject().logout();
		return "redirect:/index.jsp";
	}
	
	/**
	 * 根据学号查询用户信息
	 */
	@RequestMapping(value = "/selectByIdentityNum", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectByIdentityNum(HttpServletRequest request,String userId){
		Map<String,Object> m = new HashMap<String, Object>();
		if(userId!=null&&userId!=""){
			BaseUser user = userService.selectByIdentityNum(userId);
			m.put("userInfo", user);
			m.put("result", "success");
		}else{
			m.put("result", "false");
		}
		return m;
	}

	/**
	 * 根据学号查询用户信息
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(HttpServletRequest request,BaseUser user){
		Map<String,Object> m = new HashMap<String, Object>();
		if(user!=null){
			int result = userService.updateByIdentityNumSelective(user);
			m.put("result", "success");
		}else{
			m.put("result", "false");
		}
		return m;
	}
}
