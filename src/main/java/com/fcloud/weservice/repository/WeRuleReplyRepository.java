package com.fcloud.weservice.repository;

import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.model.WeRuleReply;
import com.fcloud.weservice.model.WeRuleReplyPictextson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

/**
 * 回复规则
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeRuleReplyRepository extends SimpleRepository<WeRuleReply> {
}
