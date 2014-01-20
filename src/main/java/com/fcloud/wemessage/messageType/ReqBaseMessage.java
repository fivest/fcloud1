package com.fcloud.wemessage.messageType;

import org.apache.log4j.Logger;

/**
 * 接受消息基础类
 * @author:kezm
 * @date :2013-11-6
 */
public abstract class ReqBaseMessage {
	
	private Logger logger = Logger.getLogger(ReqBaseMessage.class);
  
	// 开发者微信号   
	private String ToUserName; 
  
	// 发送方帐号（一个OpenID）   
	private String FromUserName;
  
	// 消息创建时间 （整型）   
	private Long CreateTime;  
  
	// 消息类型
	private String MsgType;  
   
	// 消息id
	private long MsgId;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

	  
}
