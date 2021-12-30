package com.situ.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.situ.util.ExceptionUtil;

/**
 * Spring自定义异常解析器
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", ex.getMessage());// 异常的简短概括
		mav.addObject("exception", ExceptionUtil.exceptionToString(ex));// 调用工具类显示异常的堆栈信息
		mav.addObject("popup", true);// popup是布尔值
		mav.addObject("error", "全局错误");
		mav.setViewName("global/error");
		return mav;
	}

}
