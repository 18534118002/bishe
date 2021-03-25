package com.yanxiuhair.common.exception.file;

/**
 * @ClassName:  FileSizeLimitExceededException   
 * @Description: 文件名大小限制异常类  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:51:30   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class FileSizeLimitExceededException extends FileException {
	private static final long serialVersionUID = 1L;

	public FileSizeLimitExceededException(long defaultMaxSize) {
		super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
	}
}
