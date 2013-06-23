package com.fcloud.core.model;

import com.fcloud.util.IDGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class BaseModel implements Model {

    protected String id;

    @Override
    public String getId() {
        if (id == null) {
            id = IDGenerator.newid();
        }
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
