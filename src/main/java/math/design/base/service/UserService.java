package math.design.base.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import math.design.base.mapper.BaseRoleMapper;
import math.design.base.mapper.BaseUserMapper;
import math.design.base.model.BaseRole;
import math.design.base.model.BaseUser;
import math.design.base.model.LoginUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private BaseUserMapper baseUserMapper;
	
	@Autowired
	private BaseRoleMapper baseRoleMapper;
	
	public String loginController(LoginUser loginUser , Boolean rememberMe){
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(loginUser.getIdentityNum());
		token.setPassword(loginUser.getPassword().toCharArray());
		token.setRememberMe(rememberMe);
		try {
			SecurityUtils.getSubject().login(token);
			return "success";
		} catch (AuthenticationException e) {//登陆失败
			//如果登陆失败销毁session
			Subject currentUser = SecurityUtils.getSubject();
    		Session session = currentUser.getSession();
    		session.removeAttribute("loginUser");
			
			if(e.getMessage() == "usererror"){//用户不存在
				return "usererror";
			}
			return "error";//用户密码错误
		}
	}

	/*
	 * 登录时select用户
	 */
	public LoginUser selectLogin(LoginUser user){
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
	 * 通过UserID查找用户
	 */
	public BaseUser selectByIdentityNum(String userId){
		return baseUserMapper.selectByIdentityNum(userId);
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
	 * 查找所有用户
	 */
	public List<BaseUser> selectAllUser(){
		return baseUserMapper.selectAllUser();
	}
	
	//查询用户角色
	public Set<String> findRole(BaseUser user){
		List<BaseRole> role = baseRoleMapper.findRole(user);
		if(role == null || role.size() <=0)
			return null;
		return getRolesName(role);
	}
	
	
	//转换成SET集合，shiro读取角色格式
	public Set<String> getRolesName(List<BaseRole> roles){  
        Set<String> set=new HashSet<String>();
        for(int i=0; i<roles.size(); i++){
            set.add(roles.get(i).getRoleId()+"");
        }
        return set;
    }
	
	/*
	 * 按照条件查找用户
	 */
	public List<BaseUser> selectUserIf(BaseUser baseUser){
		return baseUserMapper.selectUserIf(baseUser);
	}
	
	/*
	 * 通过IdentityNum更新用户信息
	 */
	public int updateByIdentityNumSelective(BaseUser user){
		return baseUserMapper.updateByIdentityNumSelective(user);
	}
	public int deleteById(String id){
		return baseUserMapper.deleteByIdentityNum(id);
	}
}
