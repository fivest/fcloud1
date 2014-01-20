package com.fcloud.wemessage.messageType.resp;

/**
 * @author:kezm
 * @date :2013-11-7
 */
public class Video {

	// 通过上传多媒体文件，得到的id
	private String MediaId;

	// 视频消息缩略图的媒体id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}



}
