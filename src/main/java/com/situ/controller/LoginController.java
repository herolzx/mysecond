package com.situ.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.User;
import com.situ.service.UserService;

/**
 * 登录控制器
 * 
 * @author snow1k
 * @date 2021/12/22
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService us;

	@GetMapping(value = { "", "/" })
	public String login() {
		return "login";
	}

	@PostMapping(value = { "", "/" })
	public String login(User user, Map<String, Object> map, HttpServletRequest request) {

		System.out.println("用户输入的验证码" + user.getCaptchas());

		boolean passed = us.checkLogin(user);
		String captcha = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String usercapt = user.getCaptchas();
		if (usercapt.equals(captcha)) {
			if (passed) {// 用户名和密码对应上
				request.getSession().setAttribute("##current_login_user##", user);// 登录成功向会话域中设置指定对话
				// int a = 10 / 0;

				return "redirect:/employee/list";// 成功就重定向到List页面
			} else {
				map.put("error", "用户不存在，用户名或密码错误");
				return "login";
			}
		} else {
			map.put("error", "验证码错误");
			return "login";
		}

	}
}
