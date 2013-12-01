package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WeRuleReplyText;
import com.fcloud.weservice.repository.WeRuleReplyTextRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文本回复
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/weRuleReplyText")
public class WeRuleReplyTextController extends ActionController<WeRuleReplyText,WeRuleReplyTextRepository> {

}
