package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.utils.PageBean;

public interface CustomerService {
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
