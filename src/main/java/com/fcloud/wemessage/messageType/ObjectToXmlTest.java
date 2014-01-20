package com.fcloud.wemessage.messageType;

import com.fcloud.util.ObjectToXmlUtils;
import com.fcloud.wemessage.messageType.resp.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:kezm
 * @date :2013-11-7
 */
public class ObjectToXmlTest {

	public static void main(String[] args) {
//		textMessage();
//		imageMessage();
//		musicMessage();
//		videoMessage();
//		voiceMessage();
		graphicMessage();
	}
	
	
	public static void textMessage() {
		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName("fromUserName");
		textMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		textMessage.setCreateTime(createTime);
		textMessage.setMsgType("text");
		textMessage.setContent("textContent");
		String str=ObjectToXmlUtils.textMessageToXml(textMessage);
		System.out.println(str);
	}

	public static void imageMessage() {
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName("fromUserName");
		imageMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		imageMessage.setCreateTime(createTime);
		imageMessage.setMsgType("imageMessage");
		Image image = new Image();
		image.setMediaId("mediaId");
		imageMessage.setImage(image);
		
		String str=ObjectToXmlUtils.imageMessageToXml(imageMessage);
		System.out.println(str);
	}

	public static void musicMessage() {
		MusicMessage musicMessage= new MusicMessage();
		musicMessage.setFromUserName("fromUserName");
		musicMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		musicMessage.setCreateTime(createTime);
		musicMessage.setMsgType("musicMessage");
		
		Music music = new Music();
		music.setDescription("description");
		music.setHQMusicUrl("musicUrl");
		music.setMusicUrl("musicUrl");
		music.setThumbMediaId("thumbMediaId");
		music.setTitle("title");
		musicMessage.setMusic(music);
		String str= ObjectToXmlUtils.musicMessageToXml(musicMessage);
		System.out.println(str);
	}

	public static void videoMessage() {
		VideoMessage videoMessage = new VideoMessage();
		videoMessage.setFromUserName("fromUserName");
		videoMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		videoMessage.setCreateTime(createTime);
		videoMessage.setMsgType("videoMessage");
		
		Video video = new Video();
		video.setMediaId("mediaId");
		video.setThumbMediaId("thumbMediaId");
		
		videoMessage.setVideo(video);
		String str=ObjectToXmlUtils.videoMessageToXml(videoMessage);
		System.out.println(str);
	}

	public static void voiceMessage() {
		VoiceMessage voiceMessage = new VoiceMessage ();
		
		voiceMessage.setFromUserName("fromUserName");
		voiceMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		voiceMessage.setCreateTime(createTime);
		voiceMessage.setMsgType("voiceMessage");
		
		Voice voice = new Voice();
		voice.setMediaId("mediaId");
		voiceMessage.setVoice(voice);
		String str=ObjectToXmlUtils.voiceMessageToXml(voiceMessage);
		System.out.println(str);
	}
	
	public static void graphicMessage() {
		GraphicMessage graphicMessage=new GraphicMessage();
		
		graphicMessage.setFromUserName("fromUserName");
		graphicMessage.setToUserName("toUserName");
		Long createTime =new Date().getTime();
		graphicMessage.setCreateTime(createTime);
		graphicMessage.setMsgType("graphicMessage");
		//graphicMessage.setArticleCount("articleCount");
		List<Article> articles = new ArrayList();
		Article article1 = new Article();
		article1.setTitle("title1");
		article1.setUrl("url");
		article1.setDescription("description");
		article1.setPicUrl("picUrl");
		
		Article article2 = new Article();
		article2.setTitle("title2");
		article2.setUrl("url");
		article2.setDescription("description");
		article2.setPicUrl("picUrl");
		
		articles.add(article1);
		articles.add(article2);
		graphicMessage.setArticles(articles);
		
		String str=ObjectToXmlUtils.graphicMessage(graphicMessage);
		System.out.println(str);
	}
}
