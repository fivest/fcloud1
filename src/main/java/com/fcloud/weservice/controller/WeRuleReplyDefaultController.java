package com.fcloud.weservice.controller;


import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WePublic;
import com.fcloud.weservice.model.WeRuleReplyDefault;
import com.fcloud.weservice.repository.WeRuleReplyDefaultRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 默认回复规则
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/weservice/we_rule_reply_default")
public class WeRuleReplyDefaultController extends ActionController<WeRuleReplyDefault,WeRuleReplyDefaultRepository> {

}
