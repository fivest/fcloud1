package com.fcloud.demo.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Page;
import com.fcloud.core.model.Pageable;
import com.fcloud.demo.model.MyDemo;
import com.fcloud.demo.repository.DemoRepository;
import com.fcloud.web.page.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ruben Fu
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends ActionController<MyDemo, DemoRepository> {

    // override 有效
    @Override
    public ModelAndView index(@PageableDefaults Pageable page, WebRequest request) {
        Page<MyDemo> models = getRepository().findAll(page);
        logger.info("1 #### demo controller !");
        System.out.println("2 #### demo controller !");
        return render("index", models);
    }
}
