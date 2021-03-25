package com.yanxiuhair.system.service;

import java.util.List;

import com.yanxiuhair.system.domain.SysOperLog;

/**
 * @ClassName:  ISysOperLogService   
 * @Description: 操作日志 服务层  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:41:38   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysOperLogService {
	/**
	 * 新增操作日志
	 * 
	 * @param operLog
	 *            操作日志对象
	 */
	public void insertOperlog(SysOperLog operLog);

	/**
	 * 查询系统操作日志集合
	 * 
	 * @param operLog
	 *            操作日志对象
	 * @return 操作日志集合
	 */
	public List<SysOperLog> selectOperLogList(SysOperLog operLog);

	/**
	 * 批量删除系统操作日志
	 * 
	 * @param ids
	 *            需要删除的数据
	 * @return 结果
	 */
	public int deleteOperLogByIds(String ids);

	/**
	 * 查询操作日志详细
	 * 
	 * @param operId
	 *            操作ID
	 * @return 操作日志对象
	 */
	public SysOperLog selectOperLogById(Long operId);

	/**
	 * 清空操作日志
	 */
	public void cleanOperLog();
}
