package com.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.User;
public interface UserDao extends BaseDao<User> {
	
	//根据登陆名称查询user对象
	User getByUserCode(String usercode);
}
 