package com.yanxiuhair.system.service;

import java.util.List;

import com.yanxiuhair.common.core.domain.Ztree;
import com.yanxiuhair.system.domain.SysDept;
import com.yanxiuhair.system.domain.SysRole;

/**
 * @ClassName:  ISysDeptService   
 * @Description: 部门管理 服务层  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:40:21   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface ISysDeptService {
	/**
	 * 查询部门管理数据
	 * 
	 * @param dept
	 *            部门信息
	 * @return 部门信息集合
	 */
	public List<SysDept> selectDeptList(SysDept dept);
	public List<SysDept> selectDeptList2(SysDept dept);

	/**
	 * 查询部门管理树
	 * 
	 * @param dept
	 *            部门信息
	 * @return 所有部门信息
	 */
	public List<Ztree> selectDeptTree(SysDept dept);

	/**
	 * 查询部门管理树（排除下级）
	 * 
	 * @param dept
	 *            部门信息
	 * @return 所有部门信息
	 */
	public List<Ztree> selectDeptTreeExcludeChild(SysDept dept);

	/**
	 * 根据角色ID查询菜单
	 *
	 * @param role
	 *            角色对象
	 * @return 菜单列表
	 */
	public List<Ztree> roleDeptTreeData(SysRole role);

	/**
	 * 查询部门人数
	 * 
	 * @param parentId
	 *            父部门ID
	 * @return 结果
	 */
	public int selectDeptCount(Long parentId);

	/**
	 * 查询部门是否存在用户
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 结果 true 存在 false 不存在
	 */
	public boolean checkDeptExistUser(Long deptId);

	/**
	 * 删除部门管理信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 结果
	 */
	public int deleteDeptById(Long deptId);

	/**
	 * 新增保存部门信息
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public int insertDept(SysDept dept);

	/**
	 * 修改保存部门信息
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public int updateDept(SysDept dept);

	/**
	 * 根据部门ID查询信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 部门信息
	 */
	public SysDept selectDeptById(Long deptId);

	/**
	 * 根据ID查询所有子部门（正常状态）
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 子部门数
	 */
	public int selectNormalChildrenDeptById(Long deptId);

	/**
	 * 校验部门名称是否唯一
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public String checkDeptNameUnique(SysDept dept);
}
