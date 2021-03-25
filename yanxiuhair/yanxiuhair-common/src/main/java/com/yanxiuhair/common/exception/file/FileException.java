package com.yanxiuhair.common.exception.file;

import com.yanxiuhair.common.exception.base.BaseException;

/**
 * @ClassName:  FileException   
 * @Description: 文件信息异常类  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:51:06   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class FileException extends BaseException {
	private static final long serialVersionUID = 1L;

	public FileException(String code, Object[] args) {
		super("file", code, args, null);
	}

}
