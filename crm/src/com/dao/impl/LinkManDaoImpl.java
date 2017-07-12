package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.LinkManDao;
import com.domain.LinkMan;
@Repository("linkManDao")
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {
	
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
