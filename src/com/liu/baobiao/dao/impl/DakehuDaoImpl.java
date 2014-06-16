package com.liu.baobiao.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liu.baobiao.dao.DakehuDao;
import com.liu.baobiao.model.Dakehu;

@Component("dakehuDao")
@SuppressWarnings("all")
public class DakehuDaoImpl implements DakehuDao {

	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Dakehu dakehu) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(dakehu);
	}

	@Override
	public void delete(Dakehu dakehu) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(dakehu);
	}

	@Override
	public void update(Dakehu dakehu) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(dakehu);
	}

	@Override
	public List<Dakehu> getdakehu() {
		// TODO Auto-generated method stub
		List<Dakehu> dakehus = hibernateTemplate.find("from Dakehu");
		return dakehus;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Dakehu> findBypnr(String pnr) {
		// TODO Auto-generated method stub
		List<Dakehu> dakehus = hibernateTemplate.find("from Dakehu d where d.pnr = '" + pnr + "'");
		return dakehus;
	}

	@Override
	public List<Dakehu> findByordid(String ordid) {
		// TODO Auto-generated method stub
		List<Dakehu> dakehus = hibernateTemplate.find("from Dakehu d where d.ordid = '" + ordid + "'");
		return dakehus;
	}

	@Override
	public List<Dakehu> findBychupiaoriqiandhangkonggongsi(String chupiaoriqi,String hangkonggongsi) {
		// TODO Auto-generated method stub
		List<Dakehu> dakehus = hibernateTemplate.find("from Dakehu d where d.chupiaoriqi like '" + chupiaoriqi + "%' and hangkonggongsi = '" + hangkonggongsi +"' order by caigoushang");
		return dakehus;
	}

	@Override
	public List<Dakehu> findBycaigoushang(String caigoushang) {
		// TODO Auto-generated method stub
		List<Dakehu> dakehus = hibernateTemplate.find("from Dakehu d where d.caigoushang = '" + caigoushang + "'");
		return dakehus;
	}

	@Override
	public Dakehu loadById(int id) {
		// TODO Auto-generated method stub
		Dakehu dakehu = (Dakehu)hibernateTemplate.load(Dakehu.class, id);
		return dakehu;
	}
}
