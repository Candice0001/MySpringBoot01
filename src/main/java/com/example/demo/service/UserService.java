package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.User;

public interface UserService {
	
	/**
	 * 新增用户
	 */
	void create(User user);
	
	/**
	 * 根据id删除用户
	 */
	int deleteById(int id);
	
	/**
	 * 查询所有的用户
	 * 
	 */
	List<User> getAllUser();
	
	/**
	 * 根据id查询出用户
	 */
	User getUsrByid(int id);
	
	/**
	 * 跟新用户
	 */
	int updateUsrById(User user);

}
