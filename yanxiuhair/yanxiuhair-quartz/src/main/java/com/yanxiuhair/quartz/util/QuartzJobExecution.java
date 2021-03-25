package com.yanxiuhair.quartz.util;

import org.quartz.JobExecutionContext;

import com.yanxiuhair.quartz.domain.SysJob;

/**
 * @ClassName:  QuartzJobExecution   
 * @Description: 定时任务处理（允许并发执行）  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:48:18   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class QuartzJobExecution extends AbstractQuartzJob {
	@Override
	protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
		JobInvokeUtil.invokeMethod(sysJob);
	}
}
