package com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BaseDao;
import com.domain.Customer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//用于接收运行期泛型类型
	
	
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		
		
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数
		dc.setProjection(Projections.rowCount());
		
		List<Integer> list = (List<Integer>) getHibernateTemplate().findByCriteria(dc);
		
		//清空之前设置的聚合函数
		dc.setProjection(null);
		Integer count=null;
		if(list!=null && list.size()>0){
				count = list.get(0);
				return count;
			
			
			
		}else{
			return null;
		}
		
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	
	@Override
	public void saveOrUpdate(T t) {
		try {
			getHibernateTemplate().saveOrUpdate(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
