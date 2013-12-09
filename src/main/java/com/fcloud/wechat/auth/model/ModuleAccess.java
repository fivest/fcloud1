/**
 * 
 */
package com.fcloud.wechat.auth.model;

import com.fcloud.core.model.Entity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author ruben
 *
 */
@SuppressWarnings("serial")
@DatabaseTable(tableName = "we_auth_module_access")
public class ModuleAccess extends Entity {
	
    @DatabaseField(columnName = "name", width = 500)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @DatabaseField(columnName = "path_prefix", width = 500)
	private String pathPrefix;

	public String getPathPrefix() {
		return pathPrefix;
	}

	public void setPathPrefix(String pathPrefix) {
		this.pathPrefix = pathPrefix;
	}
}
