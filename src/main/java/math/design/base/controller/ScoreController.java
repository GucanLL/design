package math.design.base.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import math.design.base.model.BaseLesson;
import math.design.base.model.BaseScore;
import math.design.base.model.BaseUser;
import math.design.base.model.DesignContent;
import math.design.base.model.LoginUser;
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
	 * 跳转全部学生成绩
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
	
	/**
	 * 跳转全部学生成绩
	 */
	@RequestMapping(value = "/selectMyScorePage",method=RequestMethod.GET)
	public String selectMyScorePage(HttpServletRequest request){
		return "/score/myScore";
	}
	
	/**
	 * 查询我的成绩
	 */
	@RequestMapping(value = "/selectMyScore",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectMyScore(HttpServletRequest request){
		LoginUser lu = (LoginUser) request.getSession().getAttribute("loginUser");
		Map<String , Object> map = new HashMap<String, Object>();
		List<BaseScore> list = scoreService.selectMyScore(lu.getIdentityNum());
		map.put("scoreList", list);
		return map;
	}
	
	public static List<BaseScore> getAllByExcel(String file,String lessonId){
        List<BaseScore> list=new ArrayList<BaseScore>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String studentId=rs.getCell(j++, i).getContents();
                    String grade=rs.getCell(j++, i).getContents();
                    BaseScore bs = new BaseScore();
                    bs.setStudentId(studentId);
                    bs.setGrade(grade);
                    bs.setLessonId(lessonId);
                    list.add(bs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
        
    }
	@RequestMapping(value = "/excelToDb",method=RequestMethod.POST)
	@ResponseBody
	public int excelToDb(BaseScore s){
		 //得到表格中所有的数据
        List<BaseScore> listExcel=getAllByExcel("f://book.xls",s.getLessonId());
        int result = 0;
        for (BaseScore bs : listExcel) {
            int isExist = scoreService.countExist(bs);
            if(isExist != 0){
            	String id = scoreService.selectBycondition(bs);
            	bs.setId(id);
            	result = scoreService.updateScore(bs);
            }else{
            	bs.setId(UUIDGenerator.getUUID());
            	result = scoreService.insertSelective(bs);
            }
        }
        return result;
    }
}
