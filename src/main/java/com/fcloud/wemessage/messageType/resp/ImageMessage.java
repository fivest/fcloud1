package com.fcloud.wemessage.messageType.resp;

import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * 回复图片消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class ImageMessage extends RespBaseMessage {

	// 图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}


}
