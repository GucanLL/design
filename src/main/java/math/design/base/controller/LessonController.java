package math.design.base.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import math.design.base.mapper.BaseLessonMapper;
import math.design.base.mapper.BaseUserMapper;
import math.design.base.model.BaseLesson;
import math.design.base.model.BaseUser;
import math.design.base.service.LessonService;
import math.design.base.service.UserService;
import math.design.util.UUIDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private UserService userService;

	/*
	 * 课程添加页面
	 */
	@RequestMapping(value = "/lessonEditPage",method=RequestMethod.GET)
	public String lessonEditPage(Model model){
		List<BaseUser> teacher = userService.selectUserByRole("2");
		model.addAttribute("teacherInfo", teacher);
		return "lessons/lessonsEdit";
	}
	
	/*
	 * 课程更新页面
	 */
	@RequestMapping(value = "/lessonUpdate/{id}",method=RequestMethod.GET)
	public String lessonUpdate(HttpServletRequest request,@PathVariable String id,Model model){
		model.addAttribute("userId", id);
		BaseLesson lesson = lessonService.selectByPrimaryKey(id);
		List<BaseUser> teacher = userService.selectUserByRole("2");
		model.addAttribute("teacherInfo", teacher);
		model.addAttribute("lesson", lesson);
		return "lessons/lessonUpdate";
	}
	
	/*
	 * 课程添加/更新
	 */
	@RequestMapping(value = "/lessonEdit",method=RequestMethod.POST)
	@ResponseBody
	public String lessonEdit(HttpServletRequest request , BaseLesson lesson ,String type){
		
		//type : 0为插入  1为更新
		int result = 0;
		List<BaseLesson> lessonsList = lessonService.countLessonsExsistByClassName(lesson.getClassName());
		if("0".equals(type)){
			lesson.setClassId(UUIDGenerator.getUUID());
			if(lesson.getIsEnable() == null){
				lesson.setIsEnable("0");
			}
			result = lessonService.insertSelective(lesson);
		}else if("1".equals(type)){
			if(lessonsList.size() < 2){
				for(BaseLesson l : lessonsList){
					lessonsList.size();
					lesson.setClassId(l.getClassId());
					result = lessonService.updateByPrimaryKeySelective(lesson);
				}
			}
		}
		
		
		if(result == 0){
			return "success";
		}
		return "error";
	}
	
	/*
	 * 课程查看
	 */
	@RequestMapping(value = "/lessonSelectPage",method=RequestMethod.GET)
	public String lessonSelect(HttpServletRequest request , Model model){
		model.addAttribute("AllLessons", lessonService.selectAllLessons());
		return "lessons/lessonSelect";
	}
	
	/*
	 * 课程删除
	 */
	@RequestMapping(value = "/delectLesson",method=RequestMethod.POST)
	@ResponseBody
	public String delectLesson(HttpServletRequest request , String type,String classId){
		int result = lessonService.deleteByPrimaryKey(classId);
		if(result > 0){
			return "success";
		}
		return "error";
	}
	
}
