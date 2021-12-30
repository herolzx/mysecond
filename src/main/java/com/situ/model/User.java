package com.situ.model;

/**
 * 用户类，此类在AjaxRequestController用作测试。
 * 
 * last modified by snow1k on 2021-01-04
 * 
 * @author snow1k
 * @version 1.0.0
 */
public class User {
	private String username;
	private String password;
	private String captchas;

	public String getCaptchas() {
		return captchas;
	}

	public void setCaptchas(String captchas) {
		this.captchas = captchas;
	}

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
