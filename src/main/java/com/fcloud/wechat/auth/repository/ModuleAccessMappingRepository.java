/**
 * 
 */
package com.fcloud.wechat.auth.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.wechat.auth.model.ModuleAccess;
import com.fcloud.wechat.auth.model.ModuleAccessMapping;
import com.fcloud.wechat.user.model.User;
import com.j256.ormlite.stmt.DeleteBuilder;

/**
 * @author ruben
 *
 */
@Repository
public class ModuleAccessMappingRepository extends SimpleRepository<ModuleAccessMapping> {

	public List<ModuleAccessMapping> findUserMapping(String userid) {
		try {
			return getDao().queryBuilder().where().eq("user_id", userid).query();
		} catch (SQLException e) {
			throw wrapException(e);
		}
	}
	
	public void updateUserMapping(User user, Iterable<ModuleAccess> modules) {
		try {
			DeleteBuilder<ModuleAccessMapping, String> db = getDao().deleteBuilder();
			db.where().eq("user_id", user.getId());
			db.delete();
			
			List<ModuleAccessMapping> maps = new ArrayList<ModuleAccessMapping>();
			for (ModuleAccess module : modules) {
				maps.add(new ModuleAccessMapping(user, module));
			}
			save(maps);
		} catch (SQLException e) {
			throw wrapException(e);
		}
	}
}
