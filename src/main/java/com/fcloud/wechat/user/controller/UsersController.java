package com.fcloud.wechat.user.controller;

import com.fcloud.core.controller.MultiResourcesController;
import com.fcloud.wechat.user.model.User;
import com.fcloud.wechat.user.validator.SignupValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ruben Fu
 */
@Controller
public class UsersController extends MultiResourcesController {

    private SignupValidator signupValidator = new SignupValidator();

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.GET)
    public ModelAndView signup() {
        return render("wechat/users/signup");
    }

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.POST)
    public ModelAndView doSignup(
            final @ModelAttribute("model") User user,
            final BindingResult result) {
        // 校验
        signupValidator.validate(user, result);
        if (result.hasErrors()) {
            return render("wechat/users/signup", user);
        }

        // 秘密相等校验
        getRepository(User.class).save(user);
        // todo 发送验证邮件

        return render("wechat/users/signup_success", user);
    }

    @RequestMapping(value = {"/login", "/users/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        return render("wechat/users/login");
    }

    @RequestMapping(value = {"/login", "/users/login"}, method = RequestMethod.POST)
    public ModelAndView doLogin(final @ModelAttribute("model") User user,
                                final BindingResult result) {
        return render("wechat/users/login_success");
    }

    @RequestMapping(value = {"/logout", "users/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {
        return render("wechat/users/logout_success");
    }

}
