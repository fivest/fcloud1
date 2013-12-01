package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.repository.WePublicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: zxpfss
 * Date: 13-11-19
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/weservice/we_public")
public class WePublicController extends ActionController<WePublic,WePublicRepository> {
}
