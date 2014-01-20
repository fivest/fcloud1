package com.fcloud.wemessage.service.impl;

import javax.annotation.Resource;

import com.fcloud.util.ObjectToXmlUtils;
import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.RespBaseMessage;
import com.fcloud.wemessage.messageType.resp.Music;
import com.fcloud.wemessage.messageType.resp.MusicMessage;
import com.fcloud.wemessage.service.IBaseMessageResp;

/**
 * @author:kezm
 * @date :2013-11-7
 */

public class VideoMessageRespServiceImpl implements IBaseMessageResp {
	
	public String getReturnMessage(ReqBaseMessage reqBaseMessage,RespBaseMessage respBaseMessage){
		MusicMessage musicMessage =(MusicMessage)respBaseMessage;
		Music music = new Music();
		//music.setTitle("\n发送了一个音乐：\n"+map.get("Title"));
		//music.setDescription("\n描述：\n"+map.get("Description"));
		musicMessage.setMusic(music);
		
		return ObjectToXmlUtils.musicMessageToXml(musicMessage);
	}
}
