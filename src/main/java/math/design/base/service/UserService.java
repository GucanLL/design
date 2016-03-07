package math.design.base.service;

import java.util.List;

import math.design.base.mapper.BaseUserMapper;
import math.design.base.model.BaseUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private BaseUserMapper baseUserMapper;
	

	/*
	 * 登录时select用户
	 */
	public BaseUser selectLogin(BaseUser user){
		return baseUserMapper.selectLogin(user);
	}

	/*
	 * 插入用户
	 */
	public int insertSelective(BaseUser user){
		return baseUserMapper.insertSelective(user);
	}

	/*
	 * 通过UserID查找用户
	 */
	public BaseUser selectByPrimaryKey(String userId){
		return baseUserMapper.selectByPrimaryKey(userId);
	}

	/*
	 * 通过UserID更新用户信息
	 */
	public int updateByPrimaryKeySelective(BaseUser user){
		return baseUserMapper.updateByPrimaryKeySelective(user);
	}

	/*
	 * 通过role查找用户
	 */
	public List<BaseUser> selectUserByRole(String role){
		return baseUserMapper.selectUserByRole(role);
	}
	
	/*
	 * 通过role查找用户
	 */
	public List<BaseUser> selectAllUser(){
		return baseUserMapper.selectAllUser();
	}
}
