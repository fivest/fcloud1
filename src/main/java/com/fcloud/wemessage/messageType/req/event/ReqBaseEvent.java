package com.fcloud.wemessage.messageType.req.event;

import com.fcloud.wemessage.messageType.ReqBaseMessage;

public class ReqBaseEvent extends ReqBaseMessage {
	private String Event;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	// 根据事件类型的不同，取值不同
	// subscribe：1事件KEY值，qrscene_为前缀，后面为二维码的参数值
	// scan :2事件KEY值，是一个32位无符号整数
	private String EventKey;

	// 二维码的ticket，可用来换取二维码图片
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
