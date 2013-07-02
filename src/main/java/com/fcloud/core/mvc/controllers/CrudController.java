package com.fcloud.core.mvc.controllers;

import com.fcloud.core.model.Model;
import com.fcloud.core.mvc.ActionResult;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CRUD基础控制器
 */
public abstract class CrudController<T extends Model> extends BaseController<T> {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ActionResult create() {
        return render("edit", BeanUtils.instantiate(modeType));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ActionResult save(T model) {
        mapper.insert(model);
        return render("success", model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ActionResult view(@PathVariable("id") String id) {
        T model = mapper.find(id);
        return render("view", model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ActionResult update(T model) {
        mapper.update(model);
        return render("success", model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ActionResult delete(@PathVariable("id") String id) {
        mapper.delete(id);
        return render("success");
    }
}
