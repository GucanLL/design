package math.design.base.service;

import java.util.List;

import math.design.base.mapper.BaseClassMapper;
import math.design.base.model.BaseClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
	
	@Autowired
	private BaseClassMapper baseClassMapper;
	
	/**
	 * 查询班级
	 */
	public BaseClass selectClass(String classId){
		return baseClassMapper.selectByPrimaryKey(classId);
	}
	
	/**
	 * 添加班级
	 */
	public int insertClass(BaseClass baseclass){
		return baseClassMapper.insertSelective(baseclass);
	}
	
	/**
	 * 删除班级
	 */
	public int deleteByPrimaryKey(String classId){
		return baseClassMapper.deleteByPrimaryKey(classId);
	}
	
	/**
	 * 升级班级
	 */
	public int updateByPrimaryKeySelective(BaseClass baseclass){
		return baseClassMapper.updateByPrimaryKeySelective(baseclass);
	}
	
	/**
	 * 查询全部班级信息
	 */
	public List<BaseClass> selectAll(){
		return baseClassMapper.selectAll();
	}
}
