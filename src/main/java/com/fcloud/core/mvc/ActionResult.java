package com.fcloud.core.mvc;

import java.util.Arrays;

/**
 * Controller返回值
 */
public class ActionResult<T> {

    private String[] rootPaths;

    private String view;

    private T model;

    private String modelName = "model";

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String[] getRootPaths() {
        return rootPaths;
    }

    public void setRootPaths(String[] rootPaths) {
        this.rootPaths = Arrays.copyOf(rootPaths, rootPaths.length);
    }

    public ActionResult() {

    }

    public ActionResult(String[] rootPaths, String view) {
        this.view = view;
        setRootPaths(rootPaths);
    }

    public ActionResult(String[] rootPaths, String view, T model) {
        this.view = view;
        this.model = model;
        setRootPaths(rootPaths);
    }

    public ActionResult(String[] rootPaths, String view, T model, String modelName) {
        this.view = view;
        this.model = model;
        this.modelName = modelName;
        setRootPaths(rootPaths);
    }
}
