package com.service;

import com.domain.User;

public interface UserService {
	User getUserByCodePassword(User u);

	void saveUser(User user);
}
