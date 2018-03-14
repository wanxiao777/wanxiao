package cn.wx.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wx.crm.entity.User;
import cn.wx.crm.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly=true)
	public User login(String username,String password){
		User user = userMapper.getUserByName(username);
		return user;
	}
}
