package com.fcloud.wechat.basic.entry;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fcloud.wechat.basic.util.EncryptUtils;
import com.fcloud.wechat.basic.util.XmlUtils;

/**
 * @author 573
 */
@Controller
@RequestMapping("/entry")
public class EntryController {
	protected final Log logger = LogFactory.getLog(getClass());
	public static final String Token = "fivest";
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String indexGET(WebRequest request) {
		System.out.println("开始");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		System.out.println("signature==" + signature);
		System.out.println("timestamp==" + timestamp);
		System.out.println("nonce==" + nonce);
		System.out.println("echostr==" + echostr);
		
		
		System.out.println("接收微信公众平台的验证");
		//String message = " <xml> <MsgId>The String ResponseBody测试</MsgId> </xml>";
		String message = "err";
		logger.info("接收微信公众平台的验证get");
		
		
		
		// 接收微信公众平台的验证
		String[] ArrTmp = { Token, timestamp, nonce };
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		String pwd =EncryptUtils.Encrypt(sb.toString());
		System.out.println("pwd==" + pwd);
		if (pwd.equals(signature)) {
			if (!"".equals(echostr) && echostr != null) {
				//response.getWriter().print(echostr);
				message=echostr;
			}
		}
		
		
		
		return message;

	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/xml; charset=utf-8")
	@ResponseBody
	public String indexPOST(HttpServletRequest request) {
		// 处理和用户交互信息
		StringBuffer sb = new StringBuffer();
		String line;
		Map<String, String> map = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			map = XmlUtils.xml2Map(new String(sb.toString().getBytes(
					"UTF-8"), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("map==" + map);
		System.out.println("xml.MsgType==" + map.get("xml.MsgType"));

		// /String resInfo = "";
		StringBuffer sbtmp = new StringBuffer();
		if ("text".equals(map.get("xml.MsgType"))) {
			// 文本消息formatTime
			sbtmp = resText("您的消息已经收到，客服将稍后联系您/:8-)", map);
		} else if ("image".equals(map.get("xml.MsgType"))) {
			// 图片消息
			sbtmp = resText("您的消息已经收到，客服将稍后联系您/:8-)", map);
		} else if ("location".equals(map.get("xml.MsgType"))) {
			// 地理位置消息
			sbtmp =resText("您的消息已经收到，客服将稍后联系您/:8-)", map);
		} else if ("link".equals(map.get("xml.MsgType"))) {
			// 链接消息
			sbtmp = resText("您的消息已经收到，客服将稍后联系您/:8-)", map);
		} else if ("voice".equals(map.get("xml.MsgType"))) {
			// 语音消息
			sbtmp = resText("您的消息已经收到，客服将稍后联系您/:8-)", map);
		} else if ("event".equals(map.get("xml.MsgType"))) {
			// 事件消息
			if ("subscribe".equals(map.get("xml.Event"))) {
				// 订阅
				// //resInfo = resText("欢迎订阅开发者！", map);
				sbtmp = resText("欢迎您关注2013中国（深圳）国际健康产业博览会", map);
			} else if ("unsubscribe".equals(map.get("xml.Event"))) {
				// 取消订阅
				System.out
						.println(map.get("xml.FromUserName") + "==用户取消订阅");
			} else if ("CLICK".equals(map.get("xml.Event"))) {
				// 自定义菜单点击事件
				//System.out.println("暂不支持自定义菜单点击事件");
				if("zhq".equals(map.get("xml.EventKey"))){
					sbtmp = resText("发送文字消息“开始”后，您发送到公众号的信息将实时同步到展会墙上。\r\n若不想再上墙请输入文字消息“取消”。", map);
					
				}
			}

		}

		//response.setCharacterEncoding("UTF-8");
		
		
		
		return sbtmp.toString();

	}
	
	
	// 回复文本消息 map:来源消息的map
	public StringBuffer resText(String str, Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml><ToUserName><![CDATA[").append(
				map.get("xml.FromUserName")).append(
				"]]></ToUserName><FromUserName><![CDATA[").append(
				map.get("xml.ToUserName")).append(
				"]]></FromUserName><CreateTime>").append(
				map.get("xml.CreateTime")).append(
				"</CreateTime><MsgType><![CDATA[text]]></MsgType>").append(
				"<Content><![CDATA[").append(str).append("]]></Content>")
				.append("<FuncFlag>0</FuncFlag></xml>");
		return sb;
	}
}
