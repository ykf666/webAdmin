package com.web.admin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.admin.dao.SysUserMapper;
import com.web.admin.model.SysUser;
import com.web.admin.model.SysUserExample;
import com.web.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SysUserMapper userMapper;
	
	/**
	 * <根据登陆名获取用户><功能实现>
	 * @param loginName
	 * @return
	 * @throws Exception
	 * @author yankefei
	 * @date 2017年2月24日 下午17:40:25
	 */
	public SysUser getUserByLoginName(String loginName) {
		try {
			SysUserExample userExample = new SysUserExample();
			SysUserExample.Criteria criteria = userExample.createCriteria();
			criteria.andUsernameEqualTo(loginName);
			List<SysUser> users = userMapper.selectByExample(userExample);
			if ( users != null && users.size() > 0 ) {
				return users.get(0);
			}else {
				logger.info("未查询到用户：{}", loginName);
			}
		} catch (Exception e) {
			logger.error("根据用户名查询用户异常：{}", e);
		}
		return null;
	}
	
}
