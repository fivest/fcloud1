package com.fcloud.wemessage.messageType.resp;

import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * @author:kezm
 * @date :2013-11-6
 */
public class MusicMessage extends RespBaseMessage {
	
	//音乐类
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}


}
