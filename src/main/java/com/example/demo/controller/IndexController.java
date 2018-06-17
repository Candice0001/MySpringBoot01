package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，
 * 		但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 *
 * 1.使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
 * 		若返回json等内容到页面，则需要加@ResponseBody注解
 * 
 * Title: IndexController.java
 * Description: 
 * @author chengge
 * @date 2018年6月11日
 *
 */

@Controller
public class IndexController {
	
	
	
	/**
	 * 
	 * Title: index
	 * Description:  
	 * @time 2018年6月11日 下午7:20:29
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("name", "testController");
		return "index.html"; //跳转到webapp下的index.html
	}
	
	@RequestMapping(value="/testjsp")
	public String testJsp(Model model) {
		model.addAttribute("name", "testController");
		return "errorpage.jsp"; //跳转到webapp下的index.html
	}

}
