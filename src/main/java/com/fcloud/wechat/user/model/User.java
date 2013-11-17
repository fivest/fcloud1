package com.fcloud.wechat.user.model;

import com.fcloud.core.model.NamedEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author Ruben Fu
 */
@DatabaseTable(tableName = "we_users")
public class User extends NamedEntity {

    /**
     * 秘密
     */
    @DatabaseField(columnName = "password", width = 200)
    protected String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 状态
     */
    @DatabaseField(columnName = "status", width = 2)
    protected Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Email
     */
    @DatabaseField(columnName = "email", width = 200)
    protected String email;

    /**
     * 电话
     */
    @DatabaseField(columnName = "mobile", width = 20)
    protected String mobile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 用户级别
     */
    @DatabaseField(canBeNull = false, foreign = true)
    protected UserLevel level;

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}
