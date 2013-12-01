package com.fcloud.weservice.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.core.model.Entity;
import com.fcloud.weservice.model.WePublicLogMusic;
import com.fcloud.weservice.repository.WePublicLogMusicRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 回复音乐消息
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Controller
@RequestMapping("/we/wePublicLogMusic")
public class WePublicLogMusicController extends ActionController<WePublicLogMusic,WePublicLogMusicRepository> {

}
