package com.fcloud.wechat.app.sccn.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 573
 */
@Controller
@RequestMapping("/wechat/app/sccn")
public class AboutController {
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = {"/bind"}, method = RequestMethod.GET)
	public String bind(WebRequest request) {
		System.out.println("账号绑定");
		return "wechat/app/sccn/bind";
	}
	
	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
	public String about(WebRequest request) {
		System.out.println("关于我们");
		return "wechat/app/sccn/about";
	}

}
