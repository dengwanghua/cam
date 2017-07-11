package com.dao;

import java.util.List;

import com.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	List<Object[]> getIndustryCount();

}
