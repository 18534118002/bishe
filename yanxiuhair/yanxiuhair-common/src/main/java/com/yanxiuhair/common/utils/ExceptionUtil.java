package com.yanxiuhair.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @ClassName:  ExceptionUtil   
 * @Description: 错误信息处理类。
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:08:29   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ExceptionUtil {
	/**
	 * 获取exception的详细错误信息。
	 */
	public static String getExceptionMessage(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		String str = sw.toString();
		return str;
	}

	public static String getRootErrorMseeage(Exception e) {
		Throwable root = ExceptionUtils.getRootCause(e);
		root = (root == null ? e : root);
		if (root == null) {
			return "";
		}
		String msg = root.getMessage();
		if (msg == null) {
			return "null";
		}
		return StringUtils.defaultString(msg);
	}
}
