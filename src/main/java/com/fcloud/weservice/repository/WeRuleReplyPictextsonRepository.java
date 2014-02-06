package com.fcloud.weservice.repository;

import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.sys.att.repository.SysAttRepository;
import com.fcloud.util.StringUtil;
import com.fcloud.weservice.model.WeRuleReplyDefault;
import com.fcloud.weservice.model.WeRuleReplyPictext;
import com.fcloud.weservice.model.WeRuleReplyPictextson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

/**
 * 子图文
 * 
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeRuleReplyPictextsonRepository extends
		SimpleRepository<WeRuleReplyPictextson> {

	@Resource
	private SysAttRepository sysAttRepository;

	public void deleteByPictextsId(String pictextsId) throws SQLException {
		getDao().deleteBuilder().where().eq("fd_werulereply", pictextsId);
	}

	@Override
	public void delete(WeRuleReplyPictextson entity) {
		if (StringUtil.isNotNull(entity.getAttId())) {
			try {
				sysAttRepository.deleteByAttId(entity.getAttId());
			} catch (Exception e) {
				e.printStackTrace();
				throw wrapException(e);
			}
		}
		super.delete(entity);
	}

	public void delete(List<WeRuleReplyPictextson> entities, List<String> attIds) {
		for (WeRuleReplyPictextson entity : entities) {
			delete(entity, attIds);
		}
	}

	public void delete(WeRuleReplyPictextson entity, List<String> attIds) {
		if (StringUtil.isNotNull(entity.getAttId())
				&& !attIds.contains(entity.getAttId())) {
			try {
				sysAttRepository.deleteByAttId(entity.getAttId());
			} catch (Exception e) {
				e.printStackTrace();
				throw wrapException(e);
			}
		}
		super.delete(entity);
	}
}
