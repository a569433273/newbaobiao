package com.liu.baobiao.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liu.baobiao.dao.HangkonggsDao;
import com.liu.baobiao.model.Hangkonggs;

@Component("HangkonggsDao")
public class HangkonggsDaoImpl implements HangkonggsDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public Hangkonggs fingbycode(String code) {
		// TODO Auto-generated method stub
		Hangkonggs hangkonggs = (Hangkonggs) hibernateTemplate.load(
				Hangkonggs.class, code);
		return hangkonggs;
	}

}
