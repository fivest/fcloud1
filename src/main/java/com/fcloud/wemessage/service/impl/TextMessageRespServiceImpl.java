package com.fcloud.wemessage.service.impl;

import javax.annotation.Resource;

import com.fcloud.util.ObjectToXmlUtils;
import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.RespBaseMessage;
import com.fcloud.wemessage.messageType.resp.TextMessage;
import com.fcloud.wemessage.service.IBaseMessageResp;

/**
 * @author:kezm
 * @date :2013-11-7
 */
public class TextMessageRespServiceImpl implements IBaseMessageResp {
	public String getReturnMessage(ReqBaseMessage reqBaseMessage,
			RespBaseMessage respBaseMessage) {
		TextMessage textMessage = (TextMessage) respBaseMessage;
		long creatTimeLong = reqBaseMessage.getCreateTime();
		textMessage.setCreateTime(creatTimeLong);
		return ObjectToXmlUtils.textMessageToXml(textMessage);
	}

}
