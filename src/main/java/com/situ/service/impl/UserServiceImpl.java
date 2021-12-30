package com.situ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.situ.dao.UserDAO;
import com.situ.model.User;
import com.situ.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;

	@Override
	public boolean checkLogin(User user) {
		User dbUser = dao.findByUsername(user.getUsername());
		System.out.println(user.getUsername());
		if (dbUser == null) {// 如果数据库中没有查到用户输入的数据，控制层中给出提示错误
			return false;
		}

		// 假如说：在数据库中新增用户的时候，密码是：username{password}的md5格式
		// 数据库中的密码比如为：admin{123456}
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());// 转换成MD5格式

		if (md5Str.equals(dbUser.getPassword())) {// 判断MD5格式是否与数据库中的密码一致
			return true;// 去往控制层
		} else {
			return false;// 去往控制层
		}
	}

}
