package com.fcloud.modules.demo.model;

import com.fcloud.core.model.BaseModel;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class DemoMain extends BaseModel {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
