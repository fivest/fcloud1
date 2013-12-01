package com.fcloud.weservice.controller;


import com.fcloud.core.controller.ActionController;
import com.fcloud.weservice.model.WeMenu;
import com.fcloud.weservice.repository.WeMenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义菜单
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/weMenu")
public class WeMenuController extends ActionController<WeMenu,WeMenuRepository> {
}
