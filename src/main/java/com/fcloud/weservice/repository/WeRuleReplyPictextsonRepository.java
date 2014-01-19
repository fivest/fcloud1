package com.fcloud.weservice.repository;

import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.weservice.model.WeRuleReplyDefault;
import com.fcloud.weservice.model.WeRuleReplyPictextson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * 子图文
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeRuleReplyPictextsonRepository extends SimpleRepository<WeRuleReplyPictextson> {
    public void deleteByPictextsId(String pictextsId) throws SQLException {
        getDao().deleteBuilder().where().eq("fd_werulereply", pictextsId);
    }
}
