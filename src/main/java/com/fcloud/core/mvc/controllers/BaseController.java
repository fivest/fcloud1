package com.fcloud.core.mvc.controllers;

import com.fcloud.core.mapper.CrudMapper;
import com.fcloud.core.model.Model;
import com.fcloud.core.mvc.ActionResult;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器基础类
 */
public abstract class BaseController <T extends Model> {

    protected CrudMapper<T> mapper;

    protected final Class<T> modeType;

    protected final String[] rootPaths;

    public BaseController() {
        modeType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseController.class);
        rootPaths = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class).value();
    }

    public Class<T> getModeType() {
        return modeType;
    }

    protected<M> ActionResult<M> render(String viewName, M model) {
        return new ActionResult<M>(rootPaths, viewName, model);
    }

    protected ActionResult<T> render(String viewName, T model) {
        return new ActionResult<T>(rootPaths, viewName, model);
    }

    protected ActionResult<T> render(String viewName) {
        return new ActionResult<T>(rootPaths, viewName);
    }
}
