package com.fcloud.wemessage.messageType.resp;


import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * 回复的文本消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class TextMessage extends RespBaseMessage {
	
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}


}
