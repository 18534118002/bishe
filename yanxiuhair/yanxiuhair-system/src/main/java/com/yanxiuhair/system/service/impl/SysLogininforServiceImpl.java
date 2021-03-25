package com.yanxiuhair.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanxiuhair.common.core.text.Convert;
import com.yanxiuhair.system.domain.SysLogininfor;
import com.yanxiuhair.system.mapper.SysLogininforMapper;
import com.yanxiuhair.system.service.ISysLogininforService;

/**
 * @ClassName:  SysLogininforServiceImpl   
 * @Description: 系统访问日志情况信息 服务层处理  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:38:35   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {

	@Autowired
	private SysLogininforMapper logininforMapper;

	/**
	 * 新增系统登录日志
	 * 
	 * @param logininfor
	 *            访问日志对象
	 */
	@Override
	public void insertLogininfor(SysLogininfor logininfor) {
		logininforMapper.insertLogininfor(logininfor);
	}

	/**
	 * 查询系统登录日志集合
	 * 
	 * @param logininfor
	 *            访问日志对象
	 * @return 登录记录集合
	 */
	@Override
	public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor) {
		return logininforMapper.selectLogininforList(logininfor);
	}

	/**
	 * 批量删除系统登录日志
	 * 
	 * @param ids
	 *            需要删除的数据
	 * @return
	 */
	@Override
	public int deleteLogininforByIds(String ids) {
		return logininforMapper.deleteLogininforByIds(Convert.toStrArray(ids));
	}

	/**
	 * 清空系统登录日志
	 */
	@Override
	public void cleanLogininfor() {
		logininforMapper.cleanLogininfor();
	}
}
