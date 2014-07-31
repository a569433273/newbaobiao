package com.liu.baobiao.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liu.baobiao.dao.FlightnameDao;
import com.liu.baobiao.model.Flightname;

@Component("FlightnameDao")
public class FlightnameDaoImpl implements FlightnameDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public Flightname findbysanzima(String sanzima) {
		// TODO Auto-generated method stub
		Flightname flightname = (Flightname) hibernateTemplate.load(
				Flightname.class, sanzima);
		return flightname;
	}

}
