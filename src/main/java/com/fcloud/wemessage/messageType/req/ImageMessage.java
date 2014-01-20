package com.fcloud.wemessage.messageType.req;


import com.fcloud.wemessage.messageType.ReqBaseMessage;

/**
 * 图片消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class ImageMessage extends ReqBaseMessage {
	
	// 图片url
	private String PicUrl;
	
	// 图片消息媒体id
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
