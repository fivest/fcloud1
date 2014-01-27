package com.fcloud.weservice.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.util.MessageUtils;
import com.fcloud.util.ObjectToXmlUtils;
import com.fcloud.util.StringUtil;
import com.fcloud.wechat.auth.model.SessionUser;
import com.fcloud.wechat.user.model.User;
import com.fcloud.wechat.user.repository.UserRepository;
import com.fcloud.wemessage.messageType.ReqBaseMessage;
import com.fcloud.wemessage.messageType.req.TextMessage;
import com.fcloud.wemessage.messageType.resp.Article;
import com.fcloud.wemessage.messageType.resp.GraphicMessage;
import com.fcloud.wemessage.util.MessageConstant;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.model.WeRuleReply;
import com.fcloud.weservice.model.WeRuleReplyDefault;
import com.fcloud.weservice.model.WeRuleReplyPictext;
import com.fcloud.weservice.model.WeRuleReplyPictexts;
import com.fcloud.weservice.model.WeRuleReplyPictextson;
import com.fcloud.weservice.model.WeRuleReplyText;
import com.j256.ormlite.dao.ForeignCollection;

/**
 * Created with IntelliJ IDEA.
 * User: zxpfss
 * Date: 13-11-19
 * Time: 下午11:05
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class WePublicRepository extends SimpleRepository<WePublic>{
    private Logger logger = Logger.getLogger(WePublicRepository.class);

    
    @Resource
    private WeRuleReplyRepository weRuleReplyRepository;
    
    @Resource
    private WeRuleReplyTextRepository weRuleReplyTextRepository;
    
    @Resource
    private WeRuleReplyPictextRepository weRuleReplyPictextRepository;
    
    @Resource
    private WeRuleReplyPictextsRepository weRuleReplyPictextsRepository;
    
    @Resource
    private WeRuleReplyPictextsonRepository weRuleReplyPictextsonRepository;
    
    @Resource
    private WeRuleReplyDefaultRepository weRuleReplyDefaultRepository;
    
    @Resource
    private UserRepository userRepository;

    @Override
	public <S extends WePublic> S save(S entity) {

        String userId = SessionUser.get().getUserid();
        User user = userRepository.findOne(userId);
        entity.setUser(user);
		return super.save(entity);
	}

	/**
     * 微信消息反馈
     * @return
     * @author：lizh
     */
    public String sendMessage(WePublic wePublic,ReqBaseMessage rbMessage,String rootPath){
        String mess = "";
        TextMessage textMessage = (TextMessage)rbMessage;
        try {
        	//根据公众号寻找需要执行的程序集
            WeRuleReply ruleReply = weRuleReplyRepository.findByPublic(wePublic,textMessage.getContent());
            if(ruleReply != null){
            	if("1".equals(ruleReply.getFdReplyType().toString())){
            		mess = getTextMsg(ruleReply,textMessage);
            	}else if("2".equals(ruleReply.getFdReplyType().toString())){
            		mess = getPictextMsg(ruleReply,textMessage,rootPath);
            	}else{
            		mess = getPictextsMsg(ruleReply,textMessage,rootPath);
            	}
            }else{
            	WeRuleReplyDefault ruleReplyDefault = weRuleReplyDefaultRepository.findDefaultByPublic(wePublic);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return mess;
    }
    
    /**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime
	 *            消息创建时间
	 * @return
	 */
	private String formatTime(String createTime) {
		// 将微信传入的CreateTime转换成long类型，再乘以1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}
	
	private String getTextMsg(WeRuleReply ruleReply,TextMessage textMessage){
		String mess = "";
		try {
			WeRuleReplyText replyText =  weRuleReplyTextRepository.findOne(ruleReply.getFdMaterial());
			if(replyText != null){
				com.fcloud.wemessage.messageType.resp.TextMessage resp = new com.fcloud.wemessage.messageType.resp.TextMessage();
				resp.setContent(replyText.getFdText());
				resp.setMsgType(textMessage.getMsgType());
				resp.setToUserName(textMessage.getFromUserName());
				resp.setFromUserName(textMessage.getToUserName());
				resp.setCreateTime(new Date().getTime());
				mess = ObjectToXmlUtils.textMessageToXml(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mess;
	}

	private String getPictextMsg(WeRuleReply ruleReply,TextMessage textMessage,String rootPath){
		String mess = "";
		List<Article> articleList = new ArrayList<Article>();  
		try {
			WeRuleReplyPictext replyPicText =  weRuleReplyPictextRepository.findOne(ruleReply.getFdMaterial());
			if(replyPicText != null){
				Article article = new Article();  
                article.setTitle(replyPicText.getFdTitle());  
                article.setDescription(replyPicText.getFdSummary());  
                if(StringUtil.isNotNull(replyPicText.getFdPic())){
                	article.setPicUrl(rootPath+replyPicText.getFdPic()); 
                }
                article.setUrl(replyPicText.getFdUrl());  
                articleList.add(article);
                GraphicMessage resp = new GraphicMessage();
                resp.setMsgType("news");
				resp.setToUserName(textMessage.getFromUserName());
				resp.setFromUserName(textMessage.getToUserName());
				resp.setCreateTime(new Date().getTime());
                resp.setArticleCount(articleList.size());
                resp.setArticles(articleList);
				mess = ObjectToXmlUtils.graphicMessage(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mess);
		return mess;	
	}
	
	private String getPictextsMsg(WeRuleReply ruleReply,TextMessage textMessage,String rootPath){
		String mess = "";
		List<Article> articleList = new ArrayList<Article>();  
		try {
			WeRuleReplyPictexts replyPicTexts =  weRuleReplyPictextsRepository.findOne(ruleReply.getFdMaterial());
			if(replyPicTexts != null){
				ForeignCollection<WeRuleReplyPictextson> weRuleReplyPictextsons = replyPicTexts.getWeRuleReplyPictextsons();
				for(WeRuleReplyPictextson picTextson:weRuleReplyPictextsons){
					Article article = new Article();  
	                article.setTitle(picTextson.getFdTitle());
	                if(StringUtil.isNotNull(picTextson.getFdPic())){
	                	article.setPicUrl(rootPath+picTextson.getFdPic()); 
	                }
	                article.setUrl(picTextson.getFdUrl());  
	                articleList.add(article);
				}
                GraphicMessage resp = new GraphicMessage();
                resp.setMsgType("news");
				resp.setToUserName(textMessage.getFromUserName());
				resp.setFromUserName(textMessage.getToUserName());
				resp.setCreateTime(new Date().getTime());
                resp.setArticleCount(articleList.size());
                resp.setArticles(articleList);
				mess = ObjectToXmlUtils.graphicMessage(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mess;	
	}
	
	private String getDefaultMsg(WeRuleReplyDefault ruleReplyDefault,TextMessage textMessage){
		String mess = "";
		String ruleType = ruleReplyDefault.getFdRuleType().toString();
		if("1".equals(ruleType)){
			com.fcloud.wemessage.messageType.resp.TextMessage resp = new com.fcloud.wemessage.messageType.resp.TextMessage();
			resp.setContent(ruleReplyDefault.getFdRuleJson());
			resp.setMsgType(textMessage.getMsgType());
			resp.setToUserName(textMessage.getFromUserName());
			resp.setFromUserName(textMessage.getToUserName());
			resp.setCreateTime(new Date().getTime());
			mess = ObjectToXmlUtils.textMessageToXml(resp);
		}else{
			
		}
		return mess;
	}
}

