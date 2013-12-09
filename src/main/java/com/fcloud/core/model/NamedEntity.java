package com.fcloud.core.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * @author Ruben Fu
 */
@SuppressWarnings("serial")
public class NamedEntity extends Entity {

    @DatabaseField(columnName = "name", width = 200, index = true, canBeNull = false)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
