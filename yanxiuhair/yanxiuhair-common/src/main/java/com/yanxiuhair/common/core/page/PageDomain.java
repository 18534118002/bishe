package com.yanxiuhair.common.core.page;

import com.yanxiuhair.common.utils.StringUtils;

/**
 * @ClassName:  PageDomain   
 * @Description: 分页数据 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:47:57   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class PageDomain {
	/** 当前记录起始索引 */
	private Integer pageNum;

	/** 每页显示记录数 */
	private Integer pageSize;

	/** 排序列 */
	private String orderByColumn;

	/** 排序的方向desc或者asc */
	private String isAsc = "asc";

	public String getOrderBy() {
		if (StringUtils.isEmpty(orderByColumn)) {
			return "";
		}
		return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public String getIsAsc() {
		return isAsc;
	}

	public void setIsAsc(String isAsc) {
		this.isAsc = isAsc;
	}
}
