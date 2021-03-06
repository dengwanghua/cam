package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.service.UserService;
import com.utils.MD5Utils;
import com.dao.UserDao;
import com.domain.User;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
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
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_code()))){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	@Override
	public void saveUser(User user) {
		User existU = ud.getByUserCode(user.getUser_code());
		if(existU!=null){
			throw new RuntimeException("用户名已经存在!");
		}
		user.setUser_password(MD5Utils.md5(user.getUser_code()));
		ud.save(user);
		
	}

}

