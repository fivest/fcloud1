package com.fcloud.core.controller;

import com.fcloud.core.model.Pageable;
import com.fcloud.web.page.PageableDefaults;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ruben Fu
 */
public interface RestController<T> {

    @Transactional(readOnly = true)
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index(@PageableDefaults Pageable page, HttpServletRequest req, HttpServletResponse resp);

    @Transactional(readOnly = true)
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("id") String id);

    @Transactional(readOnly = true)
    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") String id);

    @Transactional
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute T model);

    @Transactional(readOnly = true)
    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public ModelAndView create();

    @Transactional
    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute T model);

    @Transactional
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") String id);

    @Transactional
    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod .GET)
    public ModelAndView deleteByGet(@PathVariable("id") String id);
}
