package com.fcloud.wechat.user.repository;

import java.sql.SQLException;

import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.wechat.user.model.User;

import org.springframework.stereotype.Repository;

/**
 * @author Ruben Fu
 */
@Repository
public class UserRepository extends SimpleRepository<User> {
	
	public User findByName(String name) {
		try {
			return getDao().queryBuilder().where().eq("name", name).queryForFirst();
		} catch (SQLException e) {
			throw wrapException(e);
		}
	}
}
