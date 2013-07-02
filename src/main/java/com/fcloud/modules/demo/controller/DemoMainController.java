package com.fcloud.modules.demo.controller;

import com.fcloud.core.mvc.ActionResult;
import com.fcloud.core.mvc.controllers.CrudController;
import com.fcloud.modules.demo.mapper.DemoMainMapper;
import com.fcloud.modules.demo.model.DemoMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Demo Main Controller
 */
@Controller
@RequestMapping("/demo/main")
public class DemoMainController extends CrudController<DemoMain> {

    @Autowired
    public void setMapper(DemoMainMapper mapper) {
        this.mapper = mapper;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ActionResult<DemoMain> create() {
        DemoMain main = new DemoMain();
        main.setName("test1");
        return render("edit", main);
    }
}
