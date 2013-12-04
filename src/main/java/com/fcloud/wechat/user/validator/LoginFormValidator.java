package com.fcloud.wechat.user.validator;

import com.fcloud.wechat.user.form.LoginForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Ruben Fu
 */
public class LoginFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "登录名不可以为空！");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "密码不可以为空！");
    }
}
