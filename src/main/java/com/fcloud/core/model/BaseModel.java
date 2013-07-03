package com.fcloud.core.model;

import com.fcloud.util.IDGenerator;

/**
 * 模型基类
 */
public class BaseModel implements Model {

    protected String id;

    protected boolean _isStored;

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
        this._isStored = true;
    }

    @Override
    public final String getStoredId() {
        if (this._isStored)
            return this.id;
        return null;
    }

    public BaseModel asStored() {
        this._isStored = true;
        return this;
    }
}
