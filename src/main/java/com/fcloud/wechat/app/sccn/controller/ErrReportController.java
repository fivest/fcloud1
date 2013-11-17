package com.fcloud.wechat.app.sccn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Page;
import com.fcloud.core.model.Pageable;
import com.fcloud.web.page.PageableDefaults;
import com.fcloud.wechat.app.sccn.model.ErrReport;
import com.fcloud.wechat.app.sccn.repository.ErrReportRepository;

/**
 * 故障上报
 * 
 * @author 573
 * @date 2013-11-18
 */
@Controller
@RequestMapping("/wechat/app/sccn/errReport")
public class ErrReportController extends ActionController<ErrReport, ErrReportRepository> {

    // override 有效
    @Override
    public ModelAndView index(@PageableDefaults Pageable page, WebRequest request) {
        Page<ErrReport> models = getRepository().findAll(page);
        logger.info("ErrReport #### demo controller !");
        System.out.println("ErrReport #### demo controller !");
        //throw new RuntimeException("test transaction");
        return render("index", models);
    }
}
