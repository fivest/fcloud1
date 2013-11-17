package com.fcloud.wechat.user.model;

import com.fcloud.core.model.NamedEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author Ruben Fu
 */
@DatabaseTable(tableName = "we_user_level")
public class UserLevel extends NamedEntity {

    @DatabaseField(columnName = "value", width = 2, unique = true)
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @DatabaseField(columnName = "description", width = 4000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
