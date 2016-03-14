package math.design.util;

import java.util.Set;

import math.design.base.model.BaseUser;
import math.design.base.model.LoginUser;
import math.design.base.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroDbRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		LoginUser loginVO = new LoginUser();
		
		String[] name = token.getUsername().split("-");
		
		loginVO.setIdentityNum(name[0]);
		
		LoginUser user = userService.selectLogin(loginVO);
		if (user != null) {
			Subject currentUser = SecurityUtils.getSubject();
    		Session session = currentUser.getSession();
    		session.setAttribute("loginUser", user);
//    		doGetAuthorizationInfo(currentUser.getPrincipals());
            return new SimpleAuthenticationInfo(user.getIdentityNum(), user.getPassword(), getName());
        } else {
        	throw new AccountException("usererror");
        }
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName=(String) principals.fromRealm(getName()).iterator().next(); 
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//添加角色
		BaseUser user = new BaseUser();
		user.setName(loginName);
    	info.setRoles(userService.findRole(user));
		return info;
	}

}
