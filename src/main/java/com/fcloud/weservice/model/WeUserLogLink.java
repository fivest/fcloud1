package com.fcloud.weservice.model;

import com.fcloud.core.model.Entity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * 用户链接消息
 *
 * @author
 * @version 1.0 2013-11-12
 */
@DatabaseTable(tableName = "we_user_log_link")
public class WeUserLogLink extends Entity {

	/**
	 * 公众号二维码
	 */
    @DatabaseField(columnName = "fd_code")
	protected String fdCode;

	/**
	 * @return 公众号二维码
	 */
	public String getFdCode() {
		return fdCode;
	}

	/**
	 * @param fdCode 公众号二维码
	 */
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}

	/**
	 * OpenID
	 */
    @DatabaseField(columnName = "fd_openid")
	protected String fdOpenid;

	/**
	 * @return OpenID
	 */
	public String getFdOpenid() {
		return fdOpenid;
	}

	/**
	 * @param fdOpenid OpenID
	 */
	public void setFdOpenid(String fdOpenid) {
		this.fdOpenid = fdOpenid;
	}

	/**
	 * 消息创建时间
	 */
    @DatabaseField(columnName = "fd_createtime")
	protected Date fdCreatetime;

	/**
	 * @return 消息创建时间
	 */
	public Date getFdCreatetime() {
		return fdCreatetime;
	}

	/**
	 * @param fdCreatetime 消息创建时间
	 */
	public void setFdCreatetime(Date fdCreatetime) {
		this.fdCreatetime = fdCreatetime;
	}

	/**
	 * 消息类型
	 */
    @DatabaseField(columnName = "fd_msgtype")
	protected String fdMsgtype;

	/**
	 * @return 消息类型
	 */
	public String getFdMsgtype() {
		return fdMsgtype;
	}

	/**
	 * @param fdMsgtype 消息类型
	 */
	public void setFdMsgtype(String fdMsgtype) {
		this.fdMsgtype = fdMsgtype;
	}

	/**
	 * 消息标题
	 */
    @DatabaseField(columnName = "fd_title")
	protected String fdTitle;

	/**
	 * @return 消息标题
	 */
	public String getFdTitle() {
		return fdTitle;
	}

	/**
	 * @param fdTitle 消息标题
	 */
	public void setFdTitle(String fdTitle) {
		this.fdTitle = fdTitle;
	}

	/**
	 * 消息描述
	 */
    @DatabaseField(columnName = "fd_description")
	protected String fdDescription;

	/**
	 * @return 消息描述
	 */
	public String getFdDescription() {
		return fdDescription;
	}

	/**
	 * @param fdDescription 消息描述
	 */
	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
	}

	/**
	 * 消息链接
	 */
    @DatabaseField(columnName = "fd_url")
	protected String fdUrl;

	/**
	 * @return 消息链接
	 */
	public String getFdUrl() {
		return fdUrl;
	}

	/**
	 * @param fdUrl 消息链接
	 */
	public void setFdUrl(String fdUrl) {
		this.fdUrl = fdUrl;
	}

	/**
	 * 消息id
	 */
    @DatabaseField(columnName = "fd_msgid")
	protected String fdMsgid;

	/**
	 * @return 消息id
	 */
	public String getFdMsgid() {
		return fdMsgid;
	}

	/**
	 * @param fdMsgid 消息id
	 */
	public void setFdMsgid(String fdMsgid) {
		this.fdMsgid = fdMsgid;
	}

}
