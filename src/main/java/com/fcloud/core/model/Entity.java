package com.fcloud.core.model;

import com.fcloud.util.IdGenerator;
import com.j256.ormlite.field.DatabaseField;

/**
 * @author Ruben Fu
 */
public class Entity implements Persistable {

    @DatabaseField(id = true, columnName = "id", width = 36, canBeNull = false)
    protected String id;

    public String getId() {
        if (id == null) {
            id = IdGenerator.newId();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }
}
