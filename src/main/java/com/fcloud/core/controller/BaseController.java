package com.fcloud.core.controller;

import com.fcloud.core.model.Page;
import com.fcloud.core.model.Persistable;
import com.fcloud.core.repository.support.Repositories;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Ruben Fu
 */
public abstract class BaseController extends EventPublisherController {

    protected final Log logger = LogFactory.getLog(getClass());

    protected Repositories repositories;

    @Autowired
    public void setRepositories(Repositories repositories) {
        this.repositories = repositories;
    }

    protected final String rootPath;

    public BaseController() {
        RequestMapping rootMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
        if (rootMapping != null) {
            String rp = rootMapping.value()[0];
            rootPath = rp.substring(1);
        }
        else {
            rootPath = "";
        }
    }

    protected String resolveView(String view) {
        if (view == null || view.startsWith("/") || view.startsWith("redirect:")) {
            return view;
        }
        return rootPath + "/" + view;
    }

    protected ModelAndView render(String view) {
        return new ModelAndView(resolveView(view));
    }

    protected ModelAndView render(String view, Persistable model) {
        return new ModelAndView(resolveView(view), "model", model);
    }

    protected ModelAndView render(String view, List<?> list) {
        return new ModelAndView(resolveView(view), "list", list);
    }

    protected ModelAndView render(String view, Page<?> page) {
        return new ModelAndView(resolveView(view), "page", page);
    }
}
