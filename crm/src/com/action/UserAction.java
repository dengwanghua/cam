package com.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String login() throws Exception{
	   	User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
	   	return "toHome";
	}
	
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
	return "toLogin";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}

