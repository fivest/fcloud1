package com.fcloud.wemessage.messageType.req;


import com.fcloud.wemessage.messageType.ReqBaseMessage;

/**
 * 文本消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class TextMessage extends ReqBaseMessage {

	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
