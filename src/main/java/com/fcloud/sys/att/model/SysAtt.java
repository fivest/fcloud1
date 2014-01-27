package com.fcloud.sys.att.model;

import java.util.Date;

import com.fcloud.core.model.Entity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sys_att")
public class SysAtt extends Entity {
	@DatabaseField(columnName = "pic_url")
	private String picUrl;
	@DatabaseField(columnName = "file_url")
	private String fileUrl;
	@DatabaseField(columnName = "file_name")
	private String fileName;
	@DatabaseField(columnName = "create_time")
	private Date createTime;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
