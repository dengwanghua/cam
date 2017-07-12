package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.SaleVisitDao;
import com.domain.SaleVisit;
@Repository("saleVisitDao")
public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao{
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
