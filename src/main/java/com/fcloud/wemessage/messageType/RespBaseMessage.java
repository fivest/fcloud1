package com.fcloud.wemessage.messageType;

/**
 * 回复消息基础类
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public abstract class RespBaseMessage {
	
	// 接受放账号(收到的openId)
	private String ToUserName;
	
	// 开发者微信号
	private String FromUserName;
	
	// 消息创建时间
	private Long CreateTime;
	
	// 消息类型
	private String MsgType;

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

	public long getCreateTime() {
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

	
}
