package com.fcloud.wechat.basic.entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author 573
 */
@Controller
@RequestMapping("/entry")
public class EntryController {
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String indexGET(WebRequest request) {
		System.out.println("接收微信公众平台的验证");
		String message = " <xml> <MsgId>The String ResponseBody测试</MsgId> </xml>";
		logger.info("接收微信公众平台的验证get");
		return message;

	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String indexPOST(WebRequest request) {
		System.out.println("POSTPOST #### demo controller !");
		String message = " <xml> <MsgId>The String ResponseBody测试POST</MsgId> </xml>";
		logger.info("接收微信公众平台的验证post");
		return message;

	}

}
