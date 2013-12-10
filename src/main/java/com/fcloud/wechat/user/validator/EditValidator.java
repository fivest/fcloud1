/**
 * 
 */
package com.fcloud.wechat.user.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fcloud.wechat.user.model.User;

/**
 * @author ruben
 *
 */
public class EditValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "用户名不可以为空！");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "邮件不可以为空！");

        User user = (User) target;
        if (user.getPassword() != null || user.getPassword().length() == 0) {
        	return;
        }
        if (!user.getPassword().equals(user.getRepeatPwd())) {
            errors.rejectValue("repeatPwd", null, "秘密重复输入不一致！");
        }
    }
}
