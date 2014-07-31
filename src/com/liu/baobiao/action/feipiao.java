package com.liu.baobiao.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.liu.baobiao.dao.DakehuDao;
import com.liu.baobiao.model.Dakehu;
import com.liu.baobiao.vo.searchInfo;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("feipiao")
public class feipiao extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	@Resource
	private DakehuDao dakehuDao;

	private int shengyurenshu;

	private int newpiaomianjia;
	private int newshuifei;
	private double newzhichujine;
	private int newshishou;
	private double newlirun;

	private String newbeizhu;
	private String chupiaorenyuan = "";

	@Override
	public String execute() throws Exception {
		Dakehu dakehu = dakehuDao
				.loadById(Integer.valueOf(searchInfo.getXid()));

		HttpServletRequest request = ServletActionContext.getRequest();
		chupiaorenyuan = (String) request.getSession().getAttribute("yuangong");

		int a = Integer.valueOf(dakehu.getFeipiaorenshu())
				+ Integer.valueOf(searchInfo.getFeipiaozhangshu());

		shengyurenshu = Integer.valueOf(dakehu.getRenshu())
				- Integer.valueOf(searchInfo.getFeipiaozhangshu());

		newpiaomianjia = (Integer.valueOf(dakehu.getPiaomianjia()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newshuifei = (Integer.valueOf(dakehu.getShuifei()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newzhichujine = (Double.parseDouble(dakehu.getZhichujine()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newshishou = (Integer.valueOf(dakehu.getShishou()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu + (a * 20);
		newlirun = (Double.parseDouble(dakehu.getLirun()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu + (a * 20);

		newbeizhu = "void" + String.valueOf(a) + "’≈∆±";

		dakehu.setPiaomianjia(String.valueOf(newpiaomianjia));
		dakehu.setShuifei(String.valueOf(newshuifei));
		dakehu.setZhichujine(String.valueOf(newzhichujine));
		dakehu.setShishou(String.valueOf(newshishou));
		dakehu.setLirun(String.valueOf(newlirun));
		dakehu.setBeizhu(newbeizhu);
		dakehu.setRenshu(String.valueOf(shengyurenshu));
		dakehu.setFeipiaorenshu(String.valueOf(a));
		dakehu.setYewuyuan(chupiaorenyuan);
		dakehuDao.update(dakehu);
		return "success";
	}

	public feipiao() {

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}
}
