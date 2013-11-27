package com.fcloud.wechat.user.validator;

import com.fcloud.wechat.user.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Ruben Fu
 */
public class SignupValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "用户名不可以为空！");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "密码不可以为空！");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "邮件不可以为空！");

        User user = (User) target;
        if (!user.getPassword().equals(user.getRepeatPwd())) {
            errors.rejectValue("repeatPwd", null, "秘密重复输入不一致！");
        }
    }
}
