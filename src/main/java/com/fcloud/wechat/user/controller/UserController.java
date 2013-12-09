package com.fcloud.wechat.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fcloud.core.controller.ActionController;
import com.fcloud.wechat.user.model.User;
import com.fcloud.wechat.user.repository.UserRepository;
import com.fcloud.wechat.user.validator.EditValidator;

/**
 * @author Ruben Fu
 */
@Controller
@RequestMapping({"/wechat/user", "/user"})
public class UserController extends ActionController<User, UserRepository> {
	
	private EditValidator editValidator = new EditValidator();
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    @Transactional
    @Override
    public ModelAndView save(@ModelAttribute("model") User model, WebRequest request, BindingResult result) {
		editValidator.validate(model, result);
		if (result.hasErrors()) {
			return render("edit");
		}
        getRepository().save(model);
        return render("/public/success");
    }
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.POST)
    @Transactional
    @Override
    public ModelAndView update(@ModelAttribute("model") User model, WebRequest request, BindingResult result) {
		editValidator.validate(model, result);
		if (result.hasErrors()) {
			return render("edit");
		}
        getRepository().save(model);
        return render("/public/success");
    }
}
