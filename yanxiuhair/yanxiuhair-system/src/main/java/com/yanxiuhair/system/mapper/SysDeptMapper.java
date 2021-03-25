package com.yanxiuhair.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yanxiuhair.system.domain.SysDept;

/**
 * @ClassName:  SysDeptMapper   
 * @Description: 部门管理 数据层 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午10:34:41   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface SysDeptMapper {
	/**
	 * 查询部门人数
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public int selectDeptCount(SysDept dept);

	/**
	 * 查询部门是否存在用户
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 结果
	 */
	public int checkDeptExistUser(Long deptId);

	/**
	 * 查询部门管理数据
	 * 
	 * @param dept
	 *            部门信息
	 * @return 部门信息集合
	 */
	public List<SysDept> selectDeptList(SysDept dept);

	/**
	 * 删除部门管理信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 结果
	 */
	public int deleteDeptById(Long deptId);

	/**
	 * 新增部门信息
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public int insertDept(SysDept dept);

	/**
	 * 修改部门信息
	 * 
	 * @param dept
	 *            部门信息
	 * @return 结果
	 */
	public int updateDept(SysDept dept);

	/**
	 * 修改子元素关系
	 * 
	 * @param depts
	 *            子元素
	 * @return 结果
	 */
	public int updateDeptChildren(@Param("depts") List<SysDept> depts);

	/**
	 * 根据部门ID查询信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 部门信息
	 */
	public SysDept selectDeptById(Long deptId);

	/**
	 * 校验部门名称是否唯一
	 * 
	 * @param deptName
	 *            部门名称
	 * @param parentId
	 *            父部门ID
	 * @return 结果
	 */
	public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

	/**
	 * 根据角色ID查询部门
	 *
	 * @param roleId
	 *            角色ID
	 * @return 部门列表
	 */
	public List<String> selectRoleDeptTree(Long roleId);

	/**
	 * 修改所在部门的父级部门状态
	 * 
	 * @param dept
	 *            部门
	 */
	public void updateDeptStatus(SysDept dept);

	/**
	 * 根据ID查询所有子部门
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 部门列表
	 */
	public List<SysDept> selectChildrenDeptById(Long deptId);

	/**
	 * 根据ID查询所有子部门（正常状态）
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 子部门数
	 */
	public int selectNormalChildrenDeptById(Long deptId);
}
