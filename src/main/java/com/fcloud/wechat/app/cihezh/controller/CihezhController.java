package com.fcloud.wechat.app.cihezh.controller;

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
@RequestMapping("/wechat/app/cihezh")
public class CihezhController {
	protected final Log logger = LogFactory.getLog(getClass());

	// 展会介绍
	@RequestMapping(value = { "/hyjj" }, method = RequestMethod.GET)
	public String hyjj(WebRequest request) {
		//System.out.println("会议简介");
		return "wechat/app/cihezh/hyjj";
	}

	@RequestMapping(value = { "/hyyc" }, method = RequestMethod.GET)
	public String hyyc(WebRequest request) {
		//System.out.println("会议议程");
		return "wechat/app/cihezh/hyyc";
	}

	@RequestMapping(value = { "/yqh" }, method = RequestMethod.GET)
	public String yqh(WebRequest request) {
		//System.out.println("邀请函");
		return "wechat/app/cihezh/yqh";
	}
	
	// 展会赞助
	@RequestMapping(value = { "/sxzz" }, method = RequestMethod.GET)
	public String sxzz(WebRequest request) {
		//System.out.println("首席赞助");
		return "wechat/app/cihezh/sxzz";
	}

	@RequestMapping(value = { "/kmszz" }, method = RequestMethod.GET)
	public String kmszz(WebRequest request) {
		//System.out.println("开幕式赞助");
		return "wechat/app/cihezh/kmszz";
	}

	@RequestMapping(value = { "/lhzz" }, method = RequestMethod.GET)
	public String lhzz(WebRequest request) {
		//System.out.println("联合赞助");
		return "wechat/app/cihezh/lhzz";
	}

	// 关于我们
	@RequestMapping(value = { "/lxfs" }, method = RequestMethod.GET)
	public String lxfs(WebRequest request) {
		//System.out.println("联系方式");
		return "wechat/app/cihezh/lxfs";
	}

	@RequestMapping(value = { "/zhfk" }, method = RequestMethod.GET)
	public String zhfk(WebRequest request) {
		//System.out.println("展会反馈");
		return "wechat/app/cihezh/zhfk";
	}

	@RequestMapping(value = { "/zhld" }, method = RequestMethod.GET)
	public String zhld(WebRequest request) {
		//System.out.println("展会亮点");
		return "wechat/app/cihezh/zhld";
	}
	
	@RequestMapping(value = { "/zhxw" }, method = RequestMethod.GET)
	public String zhxw(WebRequest request) {
		//System.out.println("展会新闻");
		return "wechat/app/cihezh/zhxw";
	}
}
