package com.web.admin.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.admin.model.SysRole;
import com.web.admin.model.SysUser;
import com.web.admin.service.RoleService;
import com.web.admin.service.UserService;

@Component
public class ShiroDbRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 认证回调函数,登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser user = null;
		try {
			user = userService.getUserByLoginName(token.getUsername());
			if (user!=null) {
				return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
			}
		} catch (Exception e) {
			logger.error("query user info exception:{}", e);
		}
		logger.error("Can't find user by loginName:{} ", token.getUsername());
		return null;
	}
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		SysRole role = null;
		try {
			role = roleService.getRoleById(user.getRoleId());
			//基于Role的权限信息
			info.addRole(role.getId().toString());
			info.addRole(role.getCode());
			info.addRole(role.getRoleName());
			//基于Permission的权限信息
			info.addStringPermissions(getPermissions(role.getId()));
			
			return info;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 从数据库中查询角色拥有的权限
	 */
	private Collection<String> getPermissions(Integer roleId) {
		List<String> perms = new ArrayList<String>();
//		List<String> list = roleMenusMapperExt.findMenusCodeByRoleId(roleId);
//		for(String f : list) {
//			if (StringUtils.isNotBlank(f))
//				perms.add(f);
//		}
		return perms;
	}
	
//
//	/**
//	 * 设定Password校验的Hash算法与迭代次数.
//	 */
//	@PostConstruct
//	public void initCredentialsMatcher() {
//		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Encrypts.HASH_ALGORITHM);
//		matcher.setHashIterations(Encrypts.HASH_ITERATIONS);
//
//		setCredentialsMatcher(matcher);
//	}
//
	
}
