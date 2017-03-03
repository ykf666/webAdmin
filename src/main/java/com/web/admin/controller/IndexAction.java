package com.web.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class IndexAction {

	/**
	 * <首页>
	 *
	 * @return
	 * @author yankefei
	 * @date 2017年2月24日 下午2:51:06
	 */
	@RequestMapping("")
	public String getIndex() {
		return "index";
	}
	
	/**
	 * <登录页>
	 * 
	 * @return
	 * @author yankefei
	 * @date 2017年2月24日 下午2:23:52
	 */
	@RequestMapping(value="login")
	public String getLogin() {
		// 防止访问此接口是无限无法跳转至索引页
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "index";
		} else {
			return "login";
		}
	}
	
}
