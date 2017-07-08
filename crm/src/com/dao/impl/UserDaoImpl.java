package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getByUserCode(String usercode) {
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list=(List<User>)getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	
	}

}
