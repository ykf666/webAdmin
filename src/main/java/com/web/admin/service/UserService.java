package com.web.admin.service;

import com.web.admin.model.SysUser;

public interface UserService {
	
	//用户登陆时，根据用户名获取用户信息
	public SysUser getUserByLoginName(String username);
	
}