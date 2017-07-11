package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SaleVisitDao;
import com.domain.SaleVisit;
import com.service.SaleVisitService;
import com.utils.PageBean;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao svd;
	
	@Override
	public void save(SaleVisit saleVisit) {
		try {
			svd.saveOrUpdate(saleVisit);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}
	
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

}
