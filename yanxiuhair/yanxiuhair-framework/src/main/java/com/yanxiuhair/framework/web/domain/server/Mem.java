package com.yanxiuhair.framework.web.domain.server;

import com.yanxiuhair.common.utils.Arith;

/**
 * @ClassName:  Mem   
 * @Description: 內存相关信息 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:22:32   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Mem {
	/**
	 * 内存总量
	 */
	private double total;

	/**
	 * 已用内存
	 */
	private double used;

	/**
	 * 剩余内存
	 */
	private double free;

	public double getTotal() {
		return Arith.div(total, (1024 * 1024 * 1024), 2);
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public double getUsed() {
		return Arith.div(used, (1024 * 1024 * 1024), 2);
	}

	public void setUsed(long used) {
		this.used = used;
	}

	public double getFree() {
		return Arith.div(free, (1024 * 1024 * 1024), 2);
	}

	public void setFree(long free) {
		this.free = free;
	}

	public double getUsage() {
		return Arith.mul(Arith.div(used, total, 4), 100);
	}
}
