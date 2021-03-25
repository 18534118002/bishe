package com.yanxiuhair.web.controller.monitor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yanxiuhair.common.core.controller.BaseController;

/**
 * @ClassName:  DruidController   
 * @Description: druid 监控  
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午9:00:27   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/monitor/data")
public class DruidController extends BaseController {
	private String prefix = "/druid";

	@RequiresPermissions("monitor:data:view")
	@GetMapping()
	public String index() {
		return redirect(prefix + "/index");
	}
}
