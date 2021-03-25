package com.yanxiuhair.web.controller.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:  DemoDialogController   
 * @Description: 模态窗口 
 * @author: gaoxiaochuang   
 * @date:   2020年10月19日 上午8:57:58   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/demo/modal")
public class DemoDialogController {
	private String prefix = "demo/modal";

	/**
	 * 模态窗口
	 */
	@GetMapping("/dialog")
	public String dialog() {
		return prefix + "/dialog";
	}

	/**
	 * 弹层组件
	 */
	@GetMapping("/layer")
	public String layer() {
		return prefix + "/layer";
	}

	/**
	 * 表单
	 */
	@GetMapping("/form")
	public String form() {
		return prefix + "/form";
	}

	/**
	 * 表格
	 */
	@GetMapping("/table")
	public String table() {
		return prefix + "/table";
	}

	/**
	 * 表格check
	 */
	@GetMapping("/check")
	public String check() {
		return prefix + "/table/check";
	}

	/**
	 * 表格radio
	 */
	@GetMapping("/radio")
	public String radio() {
		return prefix + "/table/radio";
	}

	/**
	 * 表格回传父窗体
	 */
	@GetMapping("/parent")
	public String parent() {
		return prefix + "/table/parent";
	}
}
