package com.fcloud.wemessage.util;

/**
 * 消息类型常量类
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public interface MessageConstant {
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型: 音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "graphic";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	
	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：event
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：用户已关注时的事件推送
	 */
	public static final String EVENT_TYPE_SCAN = "scan";

	/**
	 * 事件类型：上报地理位置事件
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型 对应的数字编号
	 */
	public static final int  EVENT_TYPE_SUSCRIBE_NUM=1;
	
	public static final int  EVENT_TYPE_UNSUBSCRIBE_NUM=2;
	
	public static final int  EVENT_TYPE_SCAN_NUM=3;
	
	public static final int  EVENT_TYPE_LOCATION_NUM=4;
	
	public static final int  EVENT_TYPE_CLICK_NUM=5;
}
