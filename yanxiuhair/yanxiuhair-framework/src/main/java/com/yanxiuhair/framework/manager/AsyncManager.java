package com.yanxiuhair.framework.manager;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.yanxiuhair.common.utils.Threads;
import com.yanxiuhair.common.utils.spring.SpringUtils;

/**
 * @ClassName:  AsyncManager   
 * @Description: 异步任务管理器   
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:17:18   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class AsyncManager {
	/**
	 * 操作延迟10毫秒
	 */
	private final int OPERATE_DELAY_TIME = 10;

	/**
	 * 异步操作任务调度线程池
	 */
	private ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");

	/**
	 * 单例模式
	 */
	private AsyncManager() {
	}

	private static AsyncManager me = new AsyncManager();

	public static AsyncManager me() {
		return me;
	}

	/**
	 * 执行任务
	 * 
	 * @param task
	 *            任务
	 */
	public void execute(TimerTask task) {
		executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
	}

	/**
	 * 停止任务线程池
	 */
	public void shutdown() {
		Threads.shutdownAndAwaitTermination(executor);
	}
}
