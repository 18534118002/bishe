package com.yanxiuhair.common.exception.user;

/**
 * @ClassName:  UserDeleteException   
 * @Description: 用户账号已被删除   
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:52:51   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class UserDeleteException extends UserException {
	private static final long serialVersionUID = 1L;

	public UserDeleteException() {
		super("user.password.delete", null);
	}
}
