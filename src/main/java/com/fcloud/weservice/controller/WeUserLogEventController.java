package com.fcloud.weservice.controller;


import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WeUserLogEvent;
import com.fcloud.weservice.repository.WeUserLogEventRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 用户事件消息
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/weUserLogEvent")
public class WeUserLogEventController extends ActionController<WeUserLogEvent,WeUserLogEventRepository> {
}
