package com.situ.common;

/**
 * 存储公共变量
 */
public class Global {
//	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee?characterEncoding=UTF-8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
//	public static final String USER = "root";
//	public static final String PASSWORD = "123456";

	public static final String UPLOAD_PATH = "E:/uplaod";
	public static final String UPLOAD_PORTRAIT_PATH = UPLOAD_PATH + "/image/portrait" + "/";// 头像路径

	/**
	 * 获取数据库连接
	 */
//	public static Connection getConnection() {
//		return JdbcUtlis.getConnection(Global.DRIVER, Global.JDBC_URL, Global.USER, Global.PASSWORD);
//	}

	// 注释的部分全在properties中配置
}
