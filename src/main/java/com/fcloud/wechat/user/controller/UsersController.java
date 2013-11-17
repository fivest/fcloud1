package com.fcloud.wechat.user.controller;

import com.fcloud.core.controller.MultiResourcesController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ruben Fu
 */
@Controller
public class UsersController extends MultiResourcesController {

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.GET)
    public ModelAndView signup() {
        return render("users/signup");
    }

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.POST)
    public ModelAndView doSignup() {
        return render("users/signup_success");
    }

    @RequestMapping(value = {"/login", "/users/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        return render("users/login");
    }

    @RequestMapping(value = {"/login", "/users/login"}, method = RequestMethod.POST)
    public ModelAndView doLogin() {
        return render("users/login_success");
    }

    @RequestMapping(value = {"/logout", "users/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {
        return render("users/logout_success");
    }

}
