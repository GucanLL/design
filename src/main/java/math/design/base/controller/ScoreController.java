package math.design.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import math.design.base.model.BaseLesson;
import math.design.base.model.BaseScore;
import math.design.base.model.BaseUser;
import math.design.base.model.DesignContent;
import math.design.base.service.LessonService;
import math.design.base.service.ScoreService;
import math.design.base.service.UserService;
import math.design.util.UUIDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/score")
@Controller
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LessonService lessonService;
	
	/**
	 * 添加成绩
	 */
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request,BaseScore score){
		score.setId(UUIDGenerator.getUUID());
		int result = scoreService.insertSelective(score);
		if(result > 0){
			return "success";
		}
		return "error";
	}
	
	/**
	 * 查询学生是否选择某项课程
	 */
	@RequestMapping(value = "/checkExistLessonStudent",method=RequestMethod.POST)
	@ResponseBody
	public String checkExistLessonStudent(HttpServletRequest request,BaseScore score){
		int result = scoreService.countExist(score);
		if(result > 0){
			return "hasExist";
		}
		return "notExist";
	}
	
	/**
	 * 查询全部学生成绩
	 */
	@RequestMapping(value = "/selectAllStudentScore",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectAllStudentScore(HttpServletRequest request){
		Map<String , Object> map = new HashMap<String, Object>();
		List<BaseScore> list = scoreService.selectAllStudentScore();
		map.put("scoreList", list);
		return map;
	}
	
	/**
	 * 查询全部学生成绩
	 */
	@RequestMapping(value = "/selectAllStudentScorePage",method=RequestMethod.GET)
	public String selectAllStudentScorePage(HttpServletRequest request){
		return "/score/allStudentScore";
	}
	
	/**
	 * 删除成绩
	 */
	@RequestMapping(value = "/deleteScore",method=RequestMethod.POST)
	@ResponseBody
	public String deleteScore(HttpServletRequest request,String id){
		int result = scoreService.deleteByPrimaryKey(id);
		return "success";
	}

	/**
	 * 更新成绩
	 */
	@RequestMapping(value = "/updateScore",method=RequestMethod.POST)
	@ResponseBody
	public String updateScore(HttpServletRequest request,BaseScore record){
		int result = scoreService.updateScore(record);
		return "success";
	}
	
	/**
	 * 更改成绩信息页面
	 */
	@RequestMapping(value = "/editScorePage/{scoreId}",method=RequestMethod.GET)
	public String editClassPage(HttpServletRequest request,Model model,@PathVariable String scoreId){
		List<BaseUser> teacher = userService.selectUserByRole(DesignContent.TEACHER_ROLE_ID);
		model.addAttribute("lessonInfo", lessonService.selectAllLessons());
		model.addAttribute("teacherInfo", teacher);
		model.addAttribute("scoreId", scoreId);
		return "score/editScore";
	}
	
	/**
	 * 查询全部学生成绩
	 */
	@RequestMapping(value = "/selcetScoreById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selcetScoreById(HttpServletRequest request,String id){
		Map<String , Object> map = new HashMap<String, Object>();
		BaseScore bs = scoreService.selectByPrimaryKey(id);
		map.put("scoreInfo", bs);
		return map;
	}
	
	/**
	 * 添加成绩
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertScorePage",method=RequestMethod.GET)
	public String insertScorePage(HttpServletRequest request,Model model){
		List<BaseUser> student = userService.selectUserByRole(DesignContent.STUDENT_ROLE_ID);
		List<BaseUser> teacher = userService.selectUserByRole(DesignContent.TEACHER_ROLE_ID);
		List<BaseLesson> lesson = lessonService.selectAllLessons();
		model.addAttribute("studentInfo", student);
		model.addAttribute("lessonInfo", lesson);
		model.addAttribute("teacherInfo", teacher);
		return "/score/insertScore";
	}
}
