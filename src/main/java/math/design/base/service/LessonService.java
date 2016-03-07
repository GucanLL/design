package math.design.base.service;

import java.util.List;

import math.design.base.mapper.BaseLessonMapper;
import math.design.base.model.BaseLesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private BaseLessonMapper baseLessonMapper;
	
	/*
	 * 通过课程名字，查找已经存在的课程
	 */
	public List<BaseLesson> countLessonsExsistByClassName(String className){
		return baseLessonMapper.countLessonsExsistByClassName(className);
	}
	
	/*
	 * 插入数据
	 */
	public int insertSelective(BaseLesson lesson){
		return baseLessonMapper.insertSelective(lesson);
	}

	/*
	 * 更新数据
	 */
	public int updateByPrimaryKeySelective(BaseLesson lesson){
		return baseLessonMapper.updateByPrimaryKeySelective(lesson);
	}

	/*
	 * 查询所有课程
	 */
	public List<BaseLesson> selectAllLessons(){
		return baseLessonMapper.selectAllLessons();
	}

	/*
	 * 通过课程ID,删除课程
	 */
	public int deleteByPrimaryKey(String classId){
		return baseLessonMapper.deleteByPrimaryKey(classId);
	}

	/*
	 * 通过课程ID，查找课程
	 */
	public BaseLesson selectByPrimaryKey(String classId){
		return baseLessonMapper.selectByPrimaryKey(classId);
	}
}
