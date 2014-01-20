package com.fcloud.wemessage.messageType.resp;

import com.fcloud.wemessage.messageType.RespBaseMessage;

import java.util.List;


/**
 * 回复图文消息
 * 
 * @author:kezm
 * @date :2013-11-6
 */
public class GraphicMessage extends RespBaseMessage {

	// 图文消息个数，限制为10条以内
	private Integer ArticleCount;
	
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public Integer getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}


	
}
