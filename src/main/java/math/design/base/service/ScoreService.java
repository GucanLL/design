package math.design.base.service;

import java.util.List;

import math.design.base.mapper.BaseScoreMapper;
import math.design.base.model.BaseScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
	
	@Autowired
	private BaseScoreMapper baseScoreMapper;
	
	/*
	 * 插入数据
	 */
	public int insertSelective(BaseScore score){
		return baseScoreMapper.insertSelective(score);
	}

	public int countExist(BaseScore score){
		return baseScoreMapper.isExistLessonStudent(score);
	}
	
	public List<BaseScore> selectAllStudentScore(){
		return baseScoreMapper.selectAllStudentScore();
	}
	
	public int deleteByPrimaryKey(String id){
		return baseScoreMapper.deleteByPrimaryKey(id);
	}
	
	public int updateScore(BaseScore record){
		return baseScoreMapper.updateByPrimaryKeySelective(record);
	}
	
	public BaseScore selectByPrimaryKey(String id){
		return baseScoreMapper.selectByPrimaryKey(id);
	}
}
