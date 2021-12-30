package com.situ.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.situ.util.ExceptionUtil;

/**
 * 全局统一处理
 */
@ControllerAdvice
public class GlobleExceptionHanlder {

	@ExceptionHandler
	public ModelAndView handelException(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", exception.getMessage());// 异常的简短概括
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));// 调用工具类显示异常的堆栈信息
		mav.addObject("popup", true);// popup是布尔值
		mav.addObject("error", "全局错误");
		mav.setViewName("global/error");
		return mav;
	}

	@ExceptionHandler
	public ModelAndView handelException1(ArithmeticException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", exception.getMessage());// 异常的简短概括
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));// 调用工具类显示异常的堆栈信息
		mav.addObject("popup", true);// popup是布尔值
		mav.addObject("error", "全局计算异常");
		mav.setViewName("global/error");
		return mav;
	}
}
