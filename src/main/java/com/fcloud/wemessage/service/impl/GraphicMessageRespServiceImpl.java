package com.fcloud.wemessage.service.impl;


import javax.annotation.Resource;

import com.fcloud.util.ObjectToXmlUtils;
import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.RespBaseMessage;
import com.fcloud.wemessage.messageType.resp.GraphicMessage;
import com.fcloud.wemessage.service.IBaseMessageResp;

/**
 * @author:kezm
 * @date :2013-11-7
 */
public class GraphicMessageRespServiceImpl implements IBaseMessageResp {

	public String getReturnMessage(ReqBaseMessage reqBaseMessage,
			RespBaseMessage respBaseMessage) {
		GraphicMessage graphicMessage =(GraphicMessage)respBaseMessage;
		
		
		return ObjectToXmlUtils.graphicMessage(graphicMessage);
	}

}
