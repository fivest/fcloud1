package com.fcloud.wemessage.messageType.req;


import com.fcloud.wemessage.messageType.ReqBaseMessage;

/**
 * 链接消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class LinkMessage extends ReqBaseMessage {

	// 标题
	private String Title;
	
	// 描述
	private String Description;
	
	// 消息链接 
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
