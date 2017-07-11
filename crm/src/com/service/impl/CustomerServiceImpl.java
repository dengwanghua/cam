package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDao;
import com.domain.Customer;
import com.service.CustomerService;
import com.utils.PageBean;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao cd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	@Override
	public void save(Customer customer) {
		try {
			cd.saveOrUpdate(customer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
			
	}
	
	@Override
	public Customer getById(Long cust_id) {
		return cd.getById(cust_id);
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	@Override
	public List<Object[]> getIndustryCount() {
		// TODO Auto-generated method stub
		return cd.getIndustryCount();
	}
}
