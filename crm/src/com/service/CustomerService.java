package com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.Customer;
import com.utils.PageBean;

public interface CustomerService {
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Customer customer);
	//根据id获得客户对象
	Customer getById(Long cust_id);
	List<Object[]> getIndustryCount();
}
