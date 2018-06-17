package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller里面的方法都以json格式输出
public class HelloWorldController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello world";
	}
	
	@RequestMapping("/getData")
	public List<String> testJson() {
		List<String> list=new ArrayList<String>();
		list.add("hello");
		list.add("spring");
		list.add("springBoot");
		list.add("后端代码");
		list.add("前端工程师");
		list.add("企业架构师");
		return list;
	}
}
