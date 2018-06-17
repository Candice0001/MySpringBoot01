package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exception.MyException;

@Controller
public class ExceptionController {
	
	@RequestMapping("/nException")
	public String nException() throws Exception{
		throw new Exception("这里有个错误异常（Exception）");
	}
	
	@RequestMapping("/jsonException")
	public String jsonException() throws MyException{
		throw new MyException("这里有个错误异常（MyException）");
	}

}
