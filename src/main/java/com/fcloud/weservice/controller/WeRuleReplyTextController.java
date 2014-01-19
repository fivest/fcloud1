package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.weservice.model.WeRuleReply;
import com.fcloud.weservice.model.WeRuleReplyText;
import com.fcloud.weservice.repository.WeRuleReplyRepository;
import com.fcloud.weservice.repository.WeRuleReplyTextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文本回复
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/weservice/we_rule_reply_text")
public class WeRuleReplyTextController extends ActionController<WeRuleReplyText, WeRuleReplyTextRepository> {

    @Resource
    private WeRuleReplyRepository weRuleReplyRepository;

    @Override
    public ModelAndView create(WebRequest request) {
        WeRuleReplyText model = null;
        String fdRuleId = request.getParameter("ruleId");
        WeRuleReply ruleReply = weRuleReplyRepository.findOne(fdRuleId);
        if (!StringUtils.isEmpty(fdRuleId)) {
            try {
                List<WeRuleReplyText> ruleReplyTexts = getRepository().getDao().queryBuilder().where().eq("fd_werulereply", fdRuleId).query();
                if (ruleReplyTexts != null && ruleReplyTexts.size()>0){
                    model = ruleReplyTexts.get(0);
                }else {
                    model = createModel();
                }
                model.setFdWerulereply(ruleReply);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return render("edit",model);
    }

    @RequestMapping("/save")
    @Transactional
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String fdId = request.getParameter("id");
        WeRuleReplyText model = getRepository().findOne(fdId);
        if(model == null){
            model = createModel();
            model.setId(fdId);
        }
        model.setFdText(request.getParameter("fdText"));
        String fdRuleId = request.getParameter("fdWerulereply.id");
        WeRuleReply ruleReply = weRuleReplyRepository.findOne(fdRuleId);
        model.setFdWerulereply(ruleReply);
        getRepository().save(model);
        return render("/public/success");
    }
}
