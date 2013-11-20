package com.fcloud.wechat.app.sccn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Page;
import com.fcloud.core.model.Pageable;
import com.fcloud.web.page.PageableDefaults;
import com.fcloud.wechat.app.sccn.model.ErrProcess;
import com.fcloud.wechat.app.sccn.repository.ErrProcessRepository;

/**
 * 故障处理
 * 
 * @author 573
 * @date 2013-11-18
 */
@Controller
@RequestMapping("/wechat/app/sccn/errProcess")
public class ErrProcessController extends ActionController<ErrProcess, ErrProcessRepository> {



}
