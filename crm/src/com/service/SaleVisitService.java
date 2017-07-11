package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.SaleVisit;
import com.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize);

	SaleVisit getById(String visit_id);


}
