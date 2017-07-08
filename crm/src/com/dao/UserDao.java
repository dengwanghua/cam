package com.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.domain.User;
public interface UserDao {
	User getByUserCode(String usercode);
}
 