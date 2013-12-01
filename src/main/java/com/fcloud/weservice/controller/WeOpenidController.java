package com.fcloud.weservice.controller;


import com.fcloud.core.controller.ActionController;
import com.fcloud.weservice.model.WeOpenid;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.repository.WeOpenidRepository;
import com.j256.ormlite.field.DatabaseField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * OpenID
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/weOpenid")
public class WeOpenidController extends ActionController<WeOpenid,WeOpenidRepository> {

}
