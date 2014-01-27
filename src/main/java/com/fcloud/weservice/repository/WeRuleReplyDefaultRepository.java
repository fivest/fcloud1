package com.fcloud.weservice.repository;


import java.util.List;

import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.model.WePublicLogText;
import com.fcloud.weservice.model.WeRuleReply;
import com.fcloud.weservice.model.WeRuleReplyDefault;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

/**
 * 默认回复规则
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeRuleReplyDefaultRepository extends SimpleRepository<WeRuleReplyDefault> {
	//获取规则
    public WeRuleReplyDefault findDefaultByPublic(WePublic wePublic){
    	WeRuleReplyDefault ruleReplyDefault = null;
    	try {
        	List<WeRuleReplyDefault> replies = getDao().queryBuilder().where().eq("fd_wepublic", wePublic.getId()).and().eq("fd_type","1").query();
        	if(replies != null && !replies.isEmpty()){
        		ruleReplyDefault = replies.get(0);
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ruleReplyDefault;
    }
}
