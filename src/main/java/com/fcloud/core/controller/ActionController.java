package com.fcloud.core.controller;

import com.fcloud.core.model.Page;
import com.fcloud.core.model.Pageable;
import com.fcloud.core.model.Persistable;
import com.fcloud.core.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ruben Fu
 */
public abstract class ActionController<T extends Persistable, R extends PagingAndSortingRepository<T>>
        extends SingleModelController<T, R> {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView index(Pageable page, WebRequest request) {
        Page<T> models = getRepository().findAll(page);
        return render("index", models);
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView create(WebRequest request) {
        T model = createModel();
        return render("edit", model);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    @Transactional
    public ModelAndView save(@ModelAttribute T model, WebRequest request) {
        getRepository().save(model);
        return render("success");
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView view(@PathVariable("id") String id, WebRequest request) {
        T model = getRepository().findOne(id);
        return render("view", model);
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public ModelAndView edit(@PathVariable("id") String id, WebRequest request) {
        T model = getRepository().findOne(id);
        return render("edit", model);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    @Transactional
    public ModelAndView update(@ModelAttribute T model, WebRequest request) {
        getRepository().save(model);
        return render("success");
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    @Transactional
    public ModelAndView delete(@PathVariable("id") String id, WebRequest request) {
        getRepository().delete(id);
        return render("success");
    }

}
