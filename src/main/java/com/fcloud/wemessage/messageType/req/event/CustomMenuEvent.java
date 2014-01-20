package com.fcloud.wemessage.messageType.req.event;


/**自定义菜单事件
 * @author:kezm
 * @date :2013-11-7
 */
public class CustomMenuEvent extends ReqBaseEvent{

	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	
}
