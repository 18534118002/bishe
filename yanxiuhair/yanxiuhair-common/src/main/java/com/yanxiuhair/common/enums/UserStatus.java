package com.yanxiuhair.common.enums;

/**
 * @ClassName:  UserStatus   
 * @Description: 用户状态 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:50:37   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public enum UserStatus {
	OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

	private final String code;
	private final String info;

	UserStatus(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}
}
