package com.fcloud.wechat.user.controller;

import com.fcloud.core.controller.ActionController;
import com.fcloud.wechat.user.model.User;
import com.fcloud.wechat.user.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ruben Fu
 */
@Controller
@RequestMapping("/user")
public class UserController extends ActionController<User, UserRepository> {
}
