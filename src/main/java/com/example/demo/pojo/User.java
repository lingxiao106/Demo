package com.example.demo.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String username;
	private String userpwd;
	private String userid;
	@JSONField(format = "yyyy-MM-dd")
	private Date createDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
