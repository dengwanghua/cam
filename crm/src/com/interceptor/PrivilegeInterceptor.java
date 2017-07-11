package com.interceptor;

import java.util.Map;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			if(user != null){
				return invocation.invoke();
			}else{
				return "toLogin";
			}
			
	}
}
