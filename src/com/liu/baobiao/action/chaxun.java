package com.liu.baobiao.action;

import java.util.List;

import javax.annotation.Resource;

import com.liu.baobiao.dao.DakehuDao;
import com.liu.baobiao.model.Dakehu;
import com.liu.baobiao.vo.searchInfo;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("chaxun")
public class chaxun extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	private List<Dakehu> dakehus;

	private String cunzai;

	@Resource
	private DakehuDao dakehuDao;

	@Override
	public String execute() throws Exception {
		dakehus = dakehuDao.findBypnr(searchInfo.getPnrchaxun().trim());
		if (dakehus.size() > 0) {
			for (int i = 0; i < dakehus.size() - 1; i++) {
				dakehuDao.delete(dakehus.get(i));
			}
			dakehus = dakehuDao.findBypnr(searchInfo.getPnrchaxun().trim());
			cunzai = "1";
		} else {
			dakehus = dakehuDao.findByordid(searchInfo.getOrdidchaxun().trim());
			if (dakehus.size() > 0) {
				for (int i = 0; i < dakehus.size() - 1; i++) {
					dakehuDao.delete(dakehus.get(i));
				}
				dakehus = dakehuDao.findByordid(searchInfo.getOrdidchaxun()
						.trim());
				cunzai = "1";
			} else {
				cunzai = "这个订单不存在！！！快做表！！！";
			}
		}
		return "success";
	}

	public chaxun() {

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}

	public List<Dakehu> getDakehus() {
		return dakehus;
	}

	public void setDakehus(List<Dakehu> dakehus) {
		this.dakehus = dakehus;
	}

	public String getCunzai() {
		return cunzai;
	}

	public void setCunzai(String cunzai) {
		this.cunzai = cunzai;
	}

}
