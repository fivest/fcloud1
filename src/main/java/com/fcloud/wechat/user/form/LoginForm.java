package com.fcloud.wechat.user.form;

import com.fcloud.core.form.Form;

/**
 * @author Ruben Fu
 */
public class LoginForm implements Form  {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
