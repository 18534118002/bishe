package com.yanxiuhair.web.controller.system;

import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yanxiuhair.common.config.Global;
import com.yanxiuhair.common.core.controller.BaseController;
import com.yanxiuhair.common.core.text.Convert;
import com.yanxiuhair.common.utils.CookieUtils;
import com.yanxiuhair.common.utils.DateUtils;
import com.yanxiuhair.common.utils.ServletUtils;
import com.yanxiuhair.common.utils.StringUtils;
import com.yanxiuhair.framework.util.ShiroUtils;
import com.yanxiuhair.system.domain.SysMenu;
import com.yanxiuhair.system.domain.SysUser;
import com.yanxiuhair.system.service.ISysConfigService;
import com.yanxiuhair.system.service.ISysMenuService;

/**
 * @ClassName:  SysIndexController   
 * @Description: 首页 业务处理  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:03:03   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class SysIndexController extends BaseController {
	@Autowired
	private ISysMenuService menuService;

	@Autowired
	private ISysConfigService configService;

	// 系统首页
	@GetMapping("/index")
	public String index(ModelMap mmap) {
		// 取身份信息
		SysUser user = ShiroUtils.getSysUser();
		// 根据用户id取出菜单
		List<SysMenu> menus = menuService.selectMenusByUser(user);
		mmap.put("menus", menus);
		mmap.put("user", user);
		mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
		mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
		mmap.put("ignoreFooter", configService.selectConfigByKey("sys.index.ignoreFooter"));
		mmap.put("copyrightYear", Global.getCopyrightYear());
		mmap.put("demoEnabled", Global.isDemoEnabled());
		mmap.put("isDefaultModifyPwd", initPasswordIsModify(user.getPwdUpdateDate()));
		mmap.put("isPasswordExpired", passwordIsExpiration(user.getPwdUpdateDate()));

		// 菜单导航显示风格
		String menuStyle = configService.selectConfigByKey("sys.index.menuStyle");
		// 移动端，默认使左侧导航菜单，否则取默认配置
		String indexStyle = ServletUtils.checkAgentIsMobile(ServletUtils.getRequest().getHeader("User-Agent")) ? "index"
				: menuStyle;

		// 优先Cookie配置导航菜单
		Cookie[] cookies = ServletUtils.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName())) {
				indexStyle = cookie.getValue();
				break;
			}
		}
		String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
		return webIndex;
	}

	// 切换主题
	@GetMapping("/system/switchSkin")
	public String switchSkin() {
		return "skin";
	}

	// 切换菜单
	@GetMapping("/system/menuStyle/{style}")
	public void menuStyle(@PathVariable String style, HttpServletResponse response) {
		CookieUtils.setCookie(response, "nav-style", style);
	}

	// 系统介绍
	@GetMapping("/system/main")
	public String main(ModelMap mmap) {
		mmap.put("version", Global.getVersion());
		return "main";
	}

	// 检查初始密码是否提醒修改
	public boolean initPasswordIsModify(Date pwdUpdateDate) {
		int initPasswordModify = Convert.toInt(configService.selectConfigByKey("sys.account.initPasswordModify"));
		return initPasswordModify == 1 && pwdUpdateDate == null;
	}

	// 检查密码是否过期
	public boolean passwordIsExpiration(Date pwdUpdateDate) {
		int passwordValidataDays = Convert.toInt(configService.selectConfigByKey("sys.account.passwordValidataDays"));
		if (passwordValidataDays > 0) {
			if (StringUtils.isNull(pwdUpdateDate)) {
				// 如果从未修改过初始密码，直接提醒过期
				return true;
			}
			Date nowDate = DateUtils.getNowDate();
			return DateUtils.differentDaysByMillisecond(nowDate, pwdUpdateDate) > passwordValidataDays;
		}
		return false;
	}
}
