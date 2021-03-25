package com.yanxiuhair.framework.shiro.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yanxiuhair.common.constant.Constants;
import com.yanxiuhair.common.utils.MessageUtils;
import com.yanxiuhair.common.utils.StringUtils;
import com.yanxiuhair.common.utils.spring.SpringUtils;
import com.yanxiuhair.framework.manager.AsyncManager;
import com.yanxiuhair.framework.manager.factory.AsyncFactory;
import com.yanxiuhair.framework.util.ShiroUtils;
import com.yanxiuhair.system.domain.SysUser;
import com.yanxiuhair.system.service.ISysUserOnlineService;

/**
 * @ClassName:  LogoutFilter   
 * @Description: 退出过滤器
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:20:42   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {
	private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

	/**
	 * 退出后重定向的地址
	 */
	private String loginUrl;

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		try {
			Subject subject = getSubject(request, response);
			String redirectUrl = getRedirectUrl(request, response, subject);
			try {
				SysUser user = ShiroUtils.getSysUser();
				if (StringUtils.isNotNull(user)) {
					String loginName = user.getLoginName();
					// 记录用户退出日志
					AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGOUT,
							MessageUtils.message("user.logout.success")));
					// 清理缓存
					SpringUtils.getBean(ISysUserOnlineService.class).removeUserCache(loginName,
							ShiroUtils.getSessionId());
				}
				// 退出登录
				subject.logout();
			} catch (SessionException ise) {
				log.error("logout fail.", ise);
			}
			issueRedirect(request, response, redirectUrl);
		} catch (Exception e) {
			log.error("Encountered session exception during logout.  This can generally safely be ignored.", e);
		}
		return false;
	}

	/**
	 * 退出跳转URL
	 */
	@Override
	protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
		String url = getLoginUrl();
		if (StringUtils.isNotEmpty(url)) {
			return url;
		}
		return super.getRedirectUrl(request, response, subject);
	}
}
