package com.web.admin.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShiroCacheManager {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroCacheManager.class);
	
	@Autowired
	private ShiroDbRealm shiroDbRealm;
	
	public void clear() {
		logger.debug("isAuthenticationCachingEnabled = {}", shiroDbRealm.isAuthenticationCachingEnabled());
		logger.debug("isAuthorizationCachingEnabled = {}", shiroDbRealm.isAuthorizationCachingEnabled());
		
		if (shiroDbRealm.isAuthenticationCachingEnabled()) {
			logger.debug("AuthenticationCacheName = {}", shiroDbRealm.getAuthenticationCacheName());
			Cache<Object, AuthenticationInfo> cache = shiroDbRealm.getAuthenticationCache();
			if (cache != null) cache.clear();
		}
		
		if (shiroDbRealm.isAuthorizationCachingEnabled()) {
			logger.debug("AuthorizationCacheName = {}", shiroDbRealm.getAuthorizationCacheName());
			Cache<Object, AuthorizationInfo> cache = shiroDbRealm.getAuthorizationCache();
			if (cache != null) cache.clear();
		}
	}
}
