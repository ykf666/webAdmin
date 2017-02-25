package com.web.admin.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("captchaFormFilter")
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger logger = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		UsernamePasswordToken token = (UsernamePasswordToken) createToken(request, response);
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			logger.info("用户:[{}]---------------登录成功---------------", token.getUsername());
			return onLoginSuccess(token, subject, request, response);

		} catch (AuthenticationException e) {
			logger.debug("用户:[{}]---------------登录失败---------------", token.getUsername());
			return onLoginFailure(token, e, request, response);
		}
	}

	public boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}

	// 验证码校验
	/*
	 * protected void doCaptchaValidate(ServletRequest request) {
	 * HttpServletRequest httpRequest = (HttpServletRequest)request;
	 * //session中的图形码字符串 String captcha = (String)
	 * httpRequest.getSession().getAttribute(
	 * com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); //比对 if (captcha
	 * != null && !captcha.equalsIgnoreCase(getCaptcha(request))) { throw new
	 * IncorrectCaptchaException("验证码错误！"); } }
	 */

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae);
	}

}
