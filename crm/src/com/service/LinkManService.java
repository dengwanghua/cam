package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.LinkMan;
import com.utils.PageBean;

public interface LinkManService {

	public void save(LinkMan linkMan);

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	LinkMan getById(Long lkm_id);
}
