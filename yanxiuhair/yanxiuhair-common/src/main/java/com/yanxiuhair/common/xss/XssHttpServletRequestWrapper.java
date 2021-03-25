package com.yanxiuhair.common.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.yanxiuhair.common.utils.html.EscapeUtil;

/**
 * @ClassName:  XssHttpServletRequestWrapper   
 * @Description: XSS过滤处理   
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:10:21   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	/**
	 * @param request
	 */
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			int length = values.length;
			String[] escapseValues = new String[length];
			for (int i = 0; i < length; i++) {
				// 防xss攻击和过滤前后空格
				escapseValues[i] = EscapeUtil.clean(values[i]).trim();
			}
			return escapseValues;
		}
		return super.getParameterValues(name);
	}
}