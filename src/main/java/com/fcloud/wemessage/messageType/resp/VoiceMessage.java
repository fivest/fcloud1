package com.fcloud.wemessage.messageType.resp;

import com.fcloud.wemessage.messageType.RespBaseMessage;

/**
 * 回复语音消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class VoiceMessage extends RespBaseMessage {

	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}


}
