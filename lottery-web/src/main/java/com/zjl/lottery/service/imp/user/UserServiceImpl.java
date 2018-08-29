package com.zjl.lottery.service.imp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjl.lottery.dao.UserMapper;
import com.zjl.lottery.service.user.UserService;
import com.zjl.lottery.vo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired 
	UserMapper userMapper;
	public User getUserInfo(String username) {
		
		return userMapper.getUserInfo(username);
	}

}
