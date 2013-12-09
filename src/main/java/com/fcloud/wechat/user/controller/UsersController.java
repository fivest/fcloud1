package com.fcloud.wechat.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.MultiResourcesController;
import com.fcloud.wechat.auth.model.SessionUser;
import com.fcloud.wechat.user.form.LoginForm;
import com.fcloud.wechat.user.model.User;
import com.fcloud.wechat.user.repository.UserRepository;
import com.fcloud.wechat.user.validator.LoginFormValidator;
import com.fcloud.wechat.user.validator.SignupValidator;

/**
 * @author Ruben Fu
 */
@Controller
public class UsersController extends MultiResourcesController {

    private SignupValidator signupValidator = new SignupValidator();
    
    private LoginFormValidator loginFormValidator = new LoginFormValidator();

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.GET)
    public ModelAndView signup() {
        return render("wechat/users/signup", new User());
    }

    @RequestMapping(value = {"/signup", "/users/signup"}, method = RequestMethod.POST)
    @Transactional
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
        return render("wechat/users/login", new LoginForm());
    }

    @RequestMapping(value = {"/login", "/users/login"}, method = RequestMethod.POST)
    public ModelAndView doLogin(final @ModelAttribute("form") LoginForm form,
                                final BindingResult result,
                                final HttpServletRequest request) {
    	loginFormValidator.validate(form, result);
    	if (result.hasErrors()) {
    		form.setPassword(null);
    		return render("wechat/users/login", form);
    	}
    	// 
    	UserRepository ur =  getRepository(User.class);
    	User user = ur.findByName(form.getUsername());
    	if (user == null || !user.getPassword().equals(form.getPassword())) {
    		result.rejectValue("username", null, "秘密或用户名不对！");
    	}
    	// 登录成功
    	SessionUser su = new SessionUser();
    	su.setUserid(user.getId());
    	su.setUsername(user.getName());
    	request.getSession().setAttribute(SessionUser.SESSION_KEY, su);
        return render("wechat/users/login_success");
    }

    @RequestMapping(value = {"/logout", "users/logout"}, method = RequestMethod.GET)
    public ModelAndView logout(final HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
    	if (session != null) {
    		session.removeAttribute(SessionUser.SESSION_KEY);
    		session.invalidate();
    	}
        return render("wechat/users/logout_success");
    }

}
