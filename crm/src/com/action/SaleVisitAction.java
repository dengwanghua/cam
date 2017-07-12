package com.action;


import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.SaleVisit;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.SaleVisitService;
import com.utils.PageBean;
@Controller("saleVisitAction")
@Scope("prototype")
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit=new SaleVisit();
	@Resource(name="saleVisitService")
	private SaleVisitService svs ;
	//添加客户拜访记录
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		if(saleVisit.getVisit_id().equals("")){
			saleVisit.setVisit_id(null);
		}
		try {
			svs.save(saleVisit);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "toList";
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = svs.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String toEdit() throws Exception {
				//1 调用Service根据id查询客户拜访对象
				SaleVisit sv = svs.getById(saleVisit.getVisit_id());
				//2 将对象放入request域
				ActionContext.getContext().put("saleVisit", sv);
				//3 转发到add.jsp
				return "add";
	}


	@Override
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}
	
	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
