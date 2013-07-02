package com.fcloud.modules.demo.controller;

import com.fcloud.core.mvc.ActionResult;
import com.fcloud.core.mvc.controllers.CrudController;
import com.fcloud.modules.demo.model.DemoMain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-30
 * Time: 下午10:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/demo/main")
public class DemoMainController extends CrudController<DemoMain> {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ActionResult create() {
        DemoMain main = new DemoMain();
        main.setName("test1");
        return render("edit", main);
    }
}
