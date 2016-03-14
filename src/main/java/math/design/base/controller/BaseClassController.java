package math.design.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import math.design.base.model.BaseClass;
import math.design.base.model.BaseUser;
import math.design.base.model.DesignContent;
import math.design.base.service.ClassService;
import math.design.base.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/classes")
public class BaseClassController {

	@Autowired
	private ClassService classService;
	
	@Autowired
	private UserService userService;
	
	/*
	 * 添加班级页面
	 */
	@RequestMapping(value = "/addClassPage",method=RequestMethod.GET)
	public String addClassPage(HttpServletRequest request ,Model model){
		List<BaseUser> teacher = userService.selectUserByRole(DesignContent.TEACHER_ROLE_ID);
		model.addAttribute("teacherInfo", teacher);
		return "class/addClass";
	}
	
	/*
	 * 插入新班级
	 */
	@RequestMapping(value = "/addClass",method=RequestMethod.POST)
	@ResponseBody
	public String addClass(HttpServletRequest request,BaseClass baseClass){
		int result = 0;
		if(baseClass!=null){
			baseClass.setIsEnable("1");
			result = classService.insertClass(baseClass);
		}
		if(result != 0){
			return "success";
		}
		return "false";
	}
	
	/*
	 * 查询班级信息
	 */
	@RequestMapping(value = "/selectClass",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectClass(HttpServletRequest request,String classId){
		Map<String,Object> map = new HashMap<String, Object>();
		BaseClass bc = classService.selectClass(classId);
		map.put("classInfo", bc);
		return map;
	}
	
	/*
	 * 更改班级信息页面
	 */
	@RequestMapping(value = "/editClassPage/{classId}",method=RequestMethod.GET)
	public String editClassPage(HttpServletRequest request,Model model,@PathVariable String classId){
		List<BaseUser> teacher = userService.selectUserByRole(DesignContent.TEACHER_ROLE_ID);
		model.addAttribute("teacherInfo", teacher);
		model.addAttribute("classId", classId);
		return "class/editClass";
	}
	
	/*
	 * 更改班级信息
	 */
	@RequestMapping(value = "/editClass",method=RequestMethod.POST)
	@ResponseBody
	public String editClass(HttpServletRequest request,BaseClass baseClass){
		int result = 0;
		if(baseClass!=null){
			result = classService.updateByPrimaryKeySelective(baseClass);
		}
		if(result != 0){
			return "success";
		}
		return "false";
	}
	
	/*
	 * 查询全部班级页面
	 */
	@RequestMapping(value = "/selectAllClassPage",method=RequestMethod.GET)
	public String selectAllClassPage(HttpServletRequest request){
		return "class/AllClass";
	}
	
	/*
	 * 查询全部课程
	 */
	@RequestMapping(value = "/selectAllClass",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectAllClass(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		List<BaseClass> list = classService.selectAll();
		map.put("list", list);
		return map;
	}
}
