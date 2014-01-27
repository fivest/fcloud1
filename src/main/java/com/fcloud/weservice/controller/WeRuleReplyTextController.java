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
import org.springframework.web.context.request.RequestAttributes;
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
public class WeRuleReplyTextController extends
		ActionController<WeRuleReplyText, WeRuleReplyTextRepository> {

	@Resource
	private WeRuleReplyRepository weRuleReplyRepository;

	@Override
	public ModelAndView create(WebRequest request) {
		WeRuleReplyText model = null;
		try {
			String fdRuleId = request.getParameter("ruleId");
			if (!StringUtils.isEmpty(fdRuleId)) {
				WeRuleReply ruleReply = weRuleReplyRepository.findOne(fdRuleId);
				model = getRepository().findOne(ruleReply.getFdMaterial());
				if (model == null) {
					model = createModel();
				}
				request.setAttribute("ruleReplyId", ruleReply.getId(),
						RequestAttributes.SCOPE_REQUEST);

			} else {
				model = createModel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return render("edit", model);
	}

	@RequestMapping("/save")
	@Transactional
	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) {
		String fdId = request.getParameter("id");
		WeRuleReplyText model = getRepository().findOne(fdId);
		if (model == null) {
			model = createModel();
			model.setId(fdId);
		}
		model.setFdText(request.getParameter("fdText"));
		getRepository().save(model);
		String fdRuleId = request.getParameter("ruleReplyId");
		if (!StringUtils.isEmpty(fdRuleId)) {
			WeRuleReply ruleReply = weRuleReplyRepository.findOne(fdRuleId);
			ruleReply.setFdMaterial(model.getId());
			weRuleReplyRepository.save(ruleReply);
		}
		return render("/public/success");
	}
}
