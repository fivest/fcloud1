package com.fcloud.weservice.repository;

import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.weservice.model.WeRuleReplyPictext;
import com.fcloud.weservice.model.WeRuleReplyText;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 文本回复
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeRuleReplyTextRepository extends SimpleRepository<WeRuleReplyText> {
    public void deleteByRuleId(String ruleId) throws SQLException {
        List<WeRuleReplyText> ruleReplyTexts = getDao().queryBuilder().where().eq("fd_werulereply", ruleId).query();
        if (ruleReplyTexts != null && ruleReplyTexts.size() > 0) {
            WeRuleReplyText ruleReplyText = ruleReplyTexts.get(0);
            delete(ruleReplyText);
        }
    }
    
    public WeRuleReplyText findByRuleId(String ruleId) throws SQLException {
    	WeRuleReplyText ruleReplyText = null;
        List<WeRuleReplyText> ruleReplyTexts = getDao().queryBuilder().where().eq("fd_werulereply", ruleId).query();
        if (ruleReplyTexts != null && ruleReplyTexts.size() > 0) {
            ruleReplyText = ruleReplyTexts.get(0);
        }
        return ruleReplyText;
    }
}
