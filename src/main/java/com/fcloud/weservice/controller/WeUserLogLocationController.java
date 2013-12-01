package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WeUserLogLocation;
import com.fcloud.weservice.repository.WeUserLogLocationRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 用户地理位置消息
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/weUserLogLocation")
public class WeUserLogLocationController extends ActionController<WeUserLogLocation,WeUserLogLocationRepository> {

}
