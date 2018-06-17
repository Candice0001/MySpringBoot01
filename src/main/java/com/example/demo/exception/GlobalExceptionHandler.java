package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.ErrorInfo;

/**
 * 自定义全局异常处理器
 * Title: GlobalExceptionHandler.java
 * Description: 
 * @author chengge
 * @date 2018年6月11日
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static final String DEFAULT_ERROR_VIEW="error";	
	
	@ExceptionHandler(value=Exception.class)
	public String defaultErrorhandler(HttpServletRequest request,Exception e) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("errorname", "统一异常处理页面");
		mv.addObject("exception", e);
		mv.addObject("url", request.getRequestURL());
		mv.setViewName(DEFAULT_ERROR_VIEW);
		return "errorpage.jsp";//可跳转到错误页面
	}
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,MyException e) throws Exception{
		ErrorInfo<String> r=new ErrorInfo<String>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("some Data");
		r.setUrl(request.getRequestURL().toString());
		return r; //返回数据：{"code":9999,"message":"这里有个错误异常（MyException）","url":"http://localhost:8080/jsonException","data":"some Data"}
	}
}
