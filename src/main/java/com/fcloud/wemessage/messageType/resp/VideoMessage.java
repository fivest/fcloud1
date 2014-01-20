package com.fcloud.wemessage.messageType.resp;

import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * 回复视频消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class VideoMessage extends RespBaseMessage {

	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}


}
