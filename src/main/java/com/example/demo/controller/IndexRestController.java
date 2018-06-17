package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {
	
	/**
	 * 通过application.properties里面的spring.mvc.favicon.enabled=false，重新定义favicon.ico图标
	 * Title: index
	 * Description:  
	 * @time 2018年6月11日 下午7:19:12
	 * @return
	 */
	
	@RequestMapping(value="/indexRest")
	public String index() {
		return "index.html";//不会进行页面的跳转，会在页面上直接显示“index.html”字样
	}
	

}
