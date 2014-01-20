package com.fcloud.wemessage.service;

import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * @author:kezm
 * @date :2013-11-7
 */
public interface IBaseMessageResp {
	public String getReturnMessage(ReqBaseMessage reqBaseMessage,RespBaseMessage respBaseMessage);
}
