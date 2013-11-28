package com.fcloud.wechat.app.cihezh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fcloud.core.controller.ActionController;
import com.fcloud.wechat.app.cihezh.model.Zhanhfk;
import com.fcloud.wechat.app.cihezh.repository.ZhanhfkRepository;

/**
 * 展会反馈
 * 
 * @author 573
 * @date 2013-11-18
 */
@Controller
@RequestMapping("/wechat/app/cihezh/zhanhfk")
public class ZhanhfkController extends ActionController<Zhanhfk, ZhanhfkRepository> {



}
