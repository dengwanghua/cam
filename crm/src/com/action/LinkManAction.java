package com.action;

import com.domain.LinkMan;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan=new LinkMan();
	private LinkManService lms;
	
	public String add() {
		lms.save(linkMan);
		return "toList";
	}
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	public void setLms(LinkManService lms) {
		this.lms = lms;
	}
	
}
