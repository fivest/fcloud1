package com.fcloud.core.controller;

import com.fcloud.core.model.Page;
import com.fcloud.core.repository.CrudRepository;
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
public abstract class BaseController<T, R extends CrudRepository<T>> extends EventPublisherController {

    protected final Log logger = LogFactory.getLog(getClass());

    protected Repositories repositories;

    @Autowired
    public void setRepositories(Repositories repositories) {
        this.repositories = repositories;
    }

    protected final String rootPath;

    public BaseController() {
        String rp = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class).value()[0];
        rootPath = rp.substring(1);
    }

    protected ModelAndView render(String view) {
        return new ModelAndView(rootPath + "/" + view);
    }

    protected ModelAndView render(String view, T model) {
        return new ModelAndView(rootPath + "/" + view, "model", model);
    }

    protected ModelAndView render(String view, List<T> list) {
        return new ModelAndView(rootPath + "/" + view, "list", list);
    }

    protected ModelAndView render(String view, Page<T> page) {
        return new ModelAndView(rootPath + "/" + view, "page", page);
    }
}
