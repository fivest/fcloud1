package com.fcloud.util;

import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.req.*;
import com.fcloud.wemessage.messageType.req.event.ConcernsAndCancelEvent;
import com.fcloud.wemessage.messageType.req.event.CustomMenuEvent;
import com.fcloud.wemessage.messageType.req.event.DimensionalCodeScanEvent;
import com.fcloud.wemessage.messageType.req.event.ReportedLocationEvent;
import com.fcloud.wemessage.util.MessageConstant;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author lizh
 * @data 2013-12-24 下午02:37:14
 */
public class MessageUtils {
	/**
	 * 转Message对象
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static ReqBaseMessage tranMessage(HttpServletRequest request)
			throws Exception {
		ReqBaseMessage reqMess = null;
		//xml请求解析
		Map<String, String> requestMap  = xml2Map(request);
		//消息类型
		String msgType = requestMap.get("MsgType").toLowerCase();
		//文本信息
		if(MessageConstant.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){
			TextMessage message = new TextMessage();
			//文本消息内容
			message.setContent(requestMap.get("Content"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//图片
		else if(MessageConstant.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)){
			ImageMessage message = new ImageMessage();
			// 图片url
			message.setPicUrl(requestMap.get("PicUrl"));
			// 图片消息媒体id
			message.setMediaId(requestMap.get("MediaId"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//语音
		else if(MessageConstant.REQ_MESSAGE_TYPE_VOICE.equals(msgType)){
			VoiceMessage message = new VoiceMessage();
			//语音消息媒体id，可以调用多媒体文件下载接口拉取数据。 
			message.setMediaId(requestMap.get("MediaId"));
			// 语音格式，如amr，speex等 
			message.setFormat(requestMap.get("Format"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//链接
		else if(MessageConstant.REQ_MESSAGE_TYPE_LINK.equals(msgType)){
			LinkMessage message = new LinkMessage();
			// 标题
			message.setTitle(requestMap.get("Title"));
			// 描述
			message.setDescription(requestMap.get("Description"));
			// 消息链接 
			message.setUrl(requestMap.get("Url"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//地理位置
		else if(MessageConstant.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)){
			LocationMessage message = new LocationMessage();
			// 地理位置维度
			message.setLocation_X(requestMap.get("Location_X"));
			// 地理位置经度
			message.setLocation_Y(requestMap.get("Location_Y"));
			// 地图缩放大小
			message.setScale(requestMap.get("Scale"));
			// 地理位置信息
			message.setLabel(requestMap.get("Label"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//视频
		else if(MessageConstant.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)){
			VideoMessage message = new VideoMessage();
			// 视频消息媒体id
			message.setMediaId(requestMap.get("MediaId"));
			// 视频消息缩略图的媒体id
			message.setThumbMediaId(requestMap.get("ThumbMediaId"));
			setMessageContent(requestMap,message);
			reqMess = message;
		}
		//事件
		else if(MessageConstant.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
			String eventType = requestMap.get("Event");
			//关注 or 二维码
			if (MessageConstant.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
				String ticket = requestMap.get("Ticket");
				//根据ticket判断
				if(StringUtils.isBlank(ticket)){
					ConcernsAndCancelEvent message = new ConcernsAndCancelEvent();
					message.setEvent(eventType);
					setMessageContent(requestMap,message);
					reqMess = message;
				}else{
					DimensionalCodeScanEvent message = new DimensionalCodeScanEvent();
					message.setEvent(eventType);
					//事件KEY值
					message.setEventKey(requestMap.get("EventKey"));
					//二维码的ticket
					message.setTicket(ticket);
					setMessageContent(requestMap,message);
					reqMess = message;
				}
			} 
			//取关
			else if(MessageConstant.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)){
				ConcernsAndCancelEvent message = new ConcernsAndCancelEvent();
				message.setEvent(eventType);
				setMessageContent(requestMap,message);
				reqMess = message;
			}
			//推送
			else if (MessageConstant.EVENT_TYPE_SCAN.equals(eventType)) {
				DimensionalCodeScanEvent message = new DimensionalCodeScanEvent();
				message.setEvent(eventType);
				//事件KEY值
				message.setEventKey(requestMap.get("EventKey"));
				//二维码的ticket
				message.setTicket(requestMap.get("Ticket"));
				setMessageContent(requestMap,message);
				reqMess = message;
			} 
			//上报地理位置
			else if (MessageConstant.EVENT_TYPE_LOCATION.equals(eventType)) {
				ReportedLocationEvent message = new ReportedLocationEvent();
				// 事件类型，LOCATION
				message.setEvent(requestMap.get("Event"));
				// 地理位置纬度
				message.setLatitude(requestMap.get("Latitude"));
				// 地理位置经度
				message.setLongitude(requestMap.get("Longitude"));
				// 地理位置精度
				message.setPrecision(requestMap.get("Precision"));
				setMessageContent(requestMap,message);
				reqMess = message;
			} 
			//菜单点击
			else if (MessageConstant.EVENT_TYPE_CLICK.equals(eventType)) {
				CustomMenuEvent message = new CustomMenuEvent();
				// 事件类型，CLICK
				message.setEvent(requestMap.get("Event"));
				// 事件KEY值，与自定义菜单接口中KEY值对应
				message.setEventKey(requestMap.get("EventKey"));
				setMessageContent(requestMap,message);
				reqMess = message;
			}
		}
		return reqMess;
	}
	

	public <T extends ReqBaseMessage> T reObject(ReqBaseMessage message){
		String msgType = message.getMsgType();
		if(MessageConstant.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){
			
		}
		return null;
	}
	
	/**
	 * 解析（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private static Map<String, String> xml2Map(HttpServletRequest request)
			throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream = request.getInputStream();
          
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();

		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	private static void setMessageContent(Map<String,String> requestMap,ReqBaseMessage reqMess) throws Exception {
		// 发送方微信帐号
		String openId = requestMap.get("FromUserName");
		// 公众号帐号
		String publicId = requestMap.get("ToUserName");
		//消息id
		String msgId = requestMap.get("MsgId");
		if(StringUtils.isNotBlank(msgId)){
			Long msgIdLong = Long.valueOf(msgId);
			reqMess.setMsgId(msgIdLong);
		}
		//消息类型
		String msgType = requestMap.get("MsgType").toLowerCase();
		//创建时间
		String createTime = requestMap.get("CreateTime");
		Long creatTimeLong = Long.valueOf(createTime);
		reqMess.setFromUserName(openId);
		reqMess.setToUserName(publicId);
		
		reqMess.setMsgType(msgType);
		reqMess.setCreateTime(creatTimeLong);
	}
	
}
