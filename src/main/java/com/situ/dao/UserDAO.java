package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.User;

@Mapper
public interface UserDAO {
	public User findByUsername(String username);
}
