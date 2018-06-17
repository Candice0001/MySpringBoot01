package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class) //测试入口
public class DemoApplicationTests {
	
	@Autowired
	private WebApplicationContext context;
	
	//mock api 模块模拟http请求
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception{
		//集成web环境测试（此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无需启动服务）
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testUserController_Add() throws Exception{
		
		RequestBuilder requestBuilder=null;
		MvcResult mvcResult=null;
		int status=500;
		
		//新增学生
		requestBuilder=post("/user/").param("username", "candice")
				.param("password", "123456")
				.param("age", "23")
				.param("sex", "女");
		mvcResult=mvc.perform(requestBuilder).andReturn();
		status=mvcResult.getResponse().getStatus();
		if (status==200) {
			String context=mvcResult.getResponse().getContentAsString();
			System.out.println("新增："+context);
		}else {
			System.out.println("------error-----------");
		}
		
		
	}
	@Test
	public void testUserController_query() throws Exception{
		
		RequestBuilder requestBuilder=null;
		MvcResult mvcResult=null;
		int status=500;
		
		//新增学生
		requestBuilder=get("/user/");
		mvcResult=mvc.perform(requestBuilder).andReturn();
		status=mvcResult.getResponse().getStatus();
		if (status==200) {
			String context=mvcResult.getResponse().getContentAsString();
			System.out.println("查询出所有的用户："+context);
		}else {
			System.out.println("--------error---------");
		}
		
	}
	
	@Test
	public void testUserController_getOne() throws Exception{
		RequestBuilder requestBuilder=null;
		MvcResult mvcResult=null;
		int status=500;
		
		//根据id获取用户信息
		requestBuilder=get("/user/1");
		mvcResult=mvc.perform(requestBuilder).andReturn();
		status=mvcResult.getResponse().getStatus();
		if (status==200) {
			String content=mvcResult.getResponse().getContentAsString();
			System.out.println("根据Id获取用户："+content);
		}else {
			System.out.println("----------error-----------");
		}
	}
	
	@Test
	public void testUserController_update() throws Exception {
		RequestBuilder requestBuilder=null;
		MvcResult mvcResult=null;
		int status=500;
		
		requestBuilder=put("/user/").param("username", "Hery")
				.param("password", "123456")
				.param("age", "23")
				.param("sex", "男")
				.param("id", "6");
		
		mvcResult=mvc.perform(requestBuilder).andReturn();
		status=mvcResult.getResponse().getStatus();
		if (status==200) {
			String content=mvcResult.getResponse().getContentAsString();
			System.out.println("更新用户："+content);
		}else {
			System.out.println("----------error----------");
		}
	}
	
	@Test
	public void testUserController_delete() throws Exception{
		RequestBuilder requestBuilder=null;
		MvcResult mvcResult=null;
		int status=500;
		//根据id删除用户
		requestBuilder=delete("/user/7");
		mvcResult=mvc.perform(requestBuilder).andReturn();
		status=mvcResult.getResponse().getStatus();
		if (status==200) {
			String content=mvcResult.getResponse().getContentAsString();
			System.out.println("删除用户："+content);
		}
		
	}

}
