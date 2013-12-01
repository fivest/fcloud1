package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WeRuleReplyPictext;
import com.fcloud.weservice.repository.WeRuleReplyPictextRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 单图文回复
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/weservice/we_rule_reply_pictext")
public class WeRuleReplyPictextController extends ActionController<WeRuleReplyPictext,WeRuleReplyPictextRepository> {
}
