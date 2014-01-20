package com.fcloud.wemessage.messageType.req;


import com.fcloud.wemessage.messageType.ReqBaseMessage;

/**
 * 语音识别结果
 * 
 * @author:kezm
 * @date :2013-11-7
 */
public class SpeechRecognitionResult extends ReqBaseMessage {

	// 语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
	private String MediaID;

	// 语音格式：amr
	private String Format;

	// 语音识别结果，UTF8编码
	private String Recognition;

	// 消息id，64位整型
	private String MsgID;

	public String getMediaID() {
		return MediaID;
	}

	public void setMediaID(String mediaID) {
		MediaID = mediaID;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getMsgID() {
		return MsgID;
	}

	public void setMsgID(String msgID) {
		MsgID = msgID;
	}

}
