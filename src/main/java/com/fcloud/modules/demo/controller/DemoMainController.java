package com.fcloud.modules.demo.controller;

import com.fcloud.core.mvc.controllers.CrudController;
import com.fcloud.modules.demo.model.DemoMain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
