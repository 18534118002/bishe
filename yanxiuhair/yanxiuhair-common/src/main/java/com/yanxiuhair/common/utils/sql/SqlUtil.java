package com.yanxiuhair.common.utils.sql;

import com.yanxiuhair.common.exception.base.BaseException;
import com.yanxiuhair.common.utils.StringUtils;

/**
 * @ClassName:  SqlUtil   
 * @Description: sql操作工具类 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:05:16   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SqlUtil {
	/**
	 * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
	 */
	public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

	/**
	 * 检查字符，防止注入绕过
	 */
	public static String escapeOrderBySql(String value) {
		if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
			throw new BaseException("参数不符合规范，不能进行查询");
		}
		return value;
	}

	/**
	 * 验证 order by 语法是否符合规范
	 */
	public static boolean isValidOrderBySql(String value) {
		return value.matches(SQL_PATTERN);
	}
}
