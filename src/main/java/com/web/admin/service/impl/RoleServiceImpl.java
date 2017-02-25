package com.web.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.admin.dao.SysRoleMapper;
import com.web.admin.model.SysRole;
import com.web.admin.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Override
	public SysRole getRoleById(int roleId) {
		try {
			return roleMapper.selectByPrimaryKey(roleId);
		} catch (Exception e) {
			logger.error("根据id查询角色异常：{}", e);
			throw new RuntimeException(e);
		}
	}
	
}
