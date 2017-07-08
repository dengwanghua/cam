package com.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.service.UserService;
import com.dao.UserDao;
import com.domain.User;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{
	private UserDao ud;
	
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

}

