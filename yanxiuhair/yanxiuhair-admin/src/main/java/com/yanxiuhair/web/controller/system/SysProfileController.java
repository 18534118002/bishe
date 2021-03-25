package com.yanxiuhair.web.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yanxiuhair.common.annotation.Log;
import com.yanxiuhair.common.config.Global;
import com.yanxiuhair.common.core.controller.BaseController;
import com.yanxiuhair.common.core.domain.AjaxResult;
import com.yanxiuhair.common.enums.BusinessType;
import com.yanxiuhair.common.utils.DateUtils;
import com.yanxiuhair.common.utils.file.FileUploadUtils;
import com.yanxiuhair.framework.shiro.service.SysPasswordService;
import com.yanxiuhair.framework.util.ShiroUtils;
import com.yanxiuhair.system.domain.SysUser;
import com.yanxiuhair.system.service.ISysUserService;

/**
 * @ClassName:  SysProfileController   
 * @Description: 个人信息 业务处理 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:05:49   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

	private String prefix = "system/user/profile";

	@Autowired
	private ISysUserService userService;

	@Autowired
	private SysPasswordService passwordService;

	/**
	 * 个人信息
	 */
	@GetMapping()
	public String profile(ModelMap mmap) {
		SysUser user = ShiroUtils.getSysUser();
		mmap.put("user", user);
		mmap.put("roleGroup", userService.selectUserRoleGroup(user.getUserId()));
		mmap.put("postGroup", userService.selectUserPostGroup(user.getUserId()));
		return prefix + "/profile";
	}

	@GetMapping("/checkPassword")
	@ResponseBody
	public boolean checkPassword(String password) {
		SysUser user = ShiroUtils.getSysUser();
		if (passwordService.matches(user, password)) {
			return true;
		}
		return false;
	}

	@GetMapping("/resetPwd")
	public String resetPwd(ModelMap mmap) {
		SysUser user = ShiroUtils.getSysUser();
		mmap.put("user", userService.selectUserById(user.getUserId()));
		return prefix + "/resetPwd";
	}

	@Log(title = "重置密码", businessType = BusinessType.UPDATE)
	@PostMapping("/resetPwd")
	@ResponseBody
	public AjaxResult resetPwd(String oldPassword, String newPassword) {
		SysUser user = ShiroUtils.getSysUser();
		if (!passwordService.matches(user, oldPassword)) {
			return error("修改密码失败，旧密码错误");
		}
		if (passwordService.matches(user, newPassword)) {
			return error("新密码不能与旧密码相同");
		}
		user.setSalt(ShiroUtils.randomSalt());
		user.setPassword(passwordService.encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
		user.setPwdUpdateDate(DateUtils.getNowDate());
		if (userService.resetUserPwd(user) > 0) {
			ShiroUtils.setSysUser(userService.selectUserById(user.getUserId()));
			return success();
		}
		return error("修改密码异常，请联系管理员");
	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit")
	public String edit(ModelMap mmap) {
		SysUser user = ShiroUtils.getSysUser();
		mmap.put("user", userService.selectUserById(user.getUserId()));
		return prefix + "/edit";
	}

	/**
	 * 修改头像
	 */
	@GetMapping("/avatar")
	public String avatar(ModelMap mmap) {
		SysUser user = ShiroUtils.getSysUser();
		mmap.put("user", userService.selectUserById(user.getUserId()));
		return prefix + "/avatar";
	}

	/**
	 * 修改用户
	 */
	@Log(title = "个人信息", businessType = BusinessType.UPDATE)
	@PostMapping("/update")
	@ResponseBody
	public AjaxResult update(SysUser user) {
		SysUser currentUser = ShiroUtils.getSysUser();
		currentUser.setUserName(user.getUserName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhonenumber(user.getPhonenumber());
		currentUser.setSex(user.getSex());
		if (userService.updateUserInfo(currentUser) > 0) {
			ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
			return success();
		}
		return error();
	}

	/**
	 * 保存头像
	 */
	@Log(title = "个人信息", businessType = BusinessType.UPDATE)
	@PostMapping("/updateAvatar")
	@ResponseBody
	public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
		SysUser currentUser = ShiroUtils.getSysUser();
		try {
			if (!file.isEmpty()) {
				String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
				currentUser.setAvatar(avatar);
				if (userService.updateUserInfo(currentUser) > 0) {
					ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
					return success();
				}
			}
			return error();
		} catch (Exception e) {
			log.error("修改头像失败！", e);
			return error(e.getMessage());
		}
	}
}