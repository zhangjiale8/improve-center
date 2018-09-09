package com.zjl.lottery.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjl.lottery.base.Controller_;
import com.zjl.lottery.service.user.UserService;
import com.zjl.lottery.vo.User;


@Controller
public class UserController extends Controller_ {
	@Autowired
	UserService userService;
	/**
	 * 登录
	 * */
	@ResponseBody
	@RequestMapping(value = "/login.ctrl", produces = "application/json")
	public Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {
	
		String error = null;
		Object object = null;
		try {
			User user = userService.getUserInfo(username);
			object = "ok";
		}catch (Exception e) {
			error = e.getMessage();
		}
		return result(error, object);
	}
}
