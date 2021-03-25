package com.yanxiuhair.common.core.domain;

/**
 * @ClassName:  TreeEntity   
 * @Description: Tree基类 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:47:30   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TreeEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 父菜单名称 */
	private String parentName;

	/** 父菜单ID */
	private Long parentId;

	/** 显示顺序 */
	private Integer orderNum;

	/** 祖级列表 */
	private String ancestors;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}
}