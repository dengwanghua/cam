package com.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LinkManDao;
import com.domain.LinkMan;
import com.service.LinkManService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class LinkManServiceImpl implements LinkManService {
	private LinkManDao lmd;
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);

	}
	public LinkManDao getLmd() {
		return lmd;
	}
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	
}
