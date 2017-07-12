package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BaseDictDao;
import com.domain.BaseDict;
import com.service.BaseDictService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
	@Resource(name="baseDictDao")
	private BaseDictDao bdd;
	
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	
}
