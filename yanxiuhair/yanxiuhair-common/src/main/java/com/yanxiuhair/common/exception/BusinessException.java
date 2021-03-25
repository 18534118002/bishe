package com.yanxiuhair.common.exception;

/**
 * @ClassName:  BusinessException   
 * @Description: 业务异常   
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:54:23   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	protected final String message;

	public BusinessException(String message) {
		this.message = message;
	}

	public BusinessException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
