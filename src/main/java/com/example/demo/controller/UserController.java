package com.example.demo.controller;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询出所有的用户
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	/**
	 * 根据id查询出用户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUserById(@PathVariable Integer id) {
		return userService.getUsrByid(id);
	}
	
	/**
	 * 根据id删除用户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public int deleteById(@PathVariable Integer id) {
		int res=userService.deleteById(id);
		return res;
	}
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String createUser(@ModelAttribute User user) {
		userService.create(user);
		return "create success";
	}
	
	/**
	 * 更新
	 * 
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public int updateUser(@ModelAttribute User user) {
		int result=userService.updateUsrById(user);
		System.out.println("结果："+result);
		return result;
	}

}
