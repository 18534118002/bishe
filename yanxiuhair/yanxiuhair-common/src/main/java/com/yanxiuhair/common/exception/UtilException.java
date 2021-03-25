package com.yanxiuhair.common.exception;

/**
 * @ClassName:  UtilException   
 * @Description: 工具类异常   
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:54:47   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class UtilException extends RuntimeException {
	private static final long serialVersionUID = 8247610319171014183L;

	public UtilException(Throwable e) {
		super(e.getMessage(), e);
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
