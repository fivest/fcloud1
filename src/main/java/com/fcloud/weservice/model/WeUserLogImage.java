package com.fcloud.weservice.model;

import com.fcloud.core.model.Entity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * 用户图片消息
 *
 * @author
 * @version 1.0 2013-11-12
 */
@DatabaseTable(tableName = "we_user_log_image")
public class WeUserLogImage extends Entity {

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
	 * 图片链接
	 */
    @DatabaseField(columnName = "fd_picurl")
	protected String fdPicurl;

	/**
	 * @return 图片链接
	 */
	public String getFdPicurl() {
		return fdPicurl;
	}

	/**
	 * @param fdPicurl 图片链接
	 */
	public void setFdPicurl(String fdPicurl) {
		this.fdPicurl = fdPicurl;
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
