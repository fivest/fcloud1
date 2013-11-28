package com.fcloud.wechat.app.cihezh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fcloud.core.controller.ActionController;
import com.fcloud.wechat.app.cihezh.model.Canzhanshang;
import com.fcloud.wechat.app.cihezh.repository.CanzhanshangRepository;

/**
 * 参展商
 * 
 * @author 573
 * @date 2013-11-18
 */
@Controller
@RequestMapping("/wechat/app/cihezh/canzhanshang")
public class CanzhanshangController extends ActionController<Canzhanshang, CanzhanshangRepository> {



}
