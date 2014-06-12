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

	private Dakehu 		dakehu;
	private DakehuDao 	dakehuDao;

	private int 		shengyurenshu;

	private int 		newpiaomianjia;
	private int			newshuifei;
	private double 		newzhichujine;
	private int 		newshishou;
	private double 		newlirun;

	private String 		newbeizhu;
	private String chupiaorenyuan = "";

	@Override
	public String execute() throws Exception {
		dakehu = dakehuDao.loadById(Integer.valueOf(searchInfo.getXid()));
		
		HttpServletRequest request = ServletActionContext.getRequest();
		chupiaorenyuan = (String)request.getSession().getAttribute("yuangong");
		

		int a = Integer.valueOf(dakehu.getFeipiaorenshu()) + Integer.valueOf(searchInfo.getFeipiaozhangshu());
		
		shengyurenshu = Integer.valueOf(dakehu.getRenshu())
				- Integer.valueOf(searchInfo.getFeipiaozhangshu());

		newpiaomianjia = (Integer.valueOf(dakehu.getPiaomianjia()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newshuifei = (Integer.valueOf(dakehu.getShuifei()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newzhichujine = (Double.parseDouble(dakehu.getZhichujine()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu;
		newshishou = (Integer.valueOf(dakehu.getShishou()) / Integer
				.valueOf(dakehu.getRenshu())) * shengyurenshu+ (a * 20);
		newlirun = (Double.parseDouble(dakehu.getLirun()) / Integer
				.valueOf(dakehu.getRenshu()))
				* shengyurenshu
				+ (a * 20);

		
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

	public searchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(searchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}

	public Dakehu getDakehu() {
		return dakehu;
	}

	public void setDakehu(Dakehu dakehu) {
		this.dakehu = dakehu;
	}

	public DakehuDao getDakehuDao() {
		return dakehuDao;
	}

	@Resource
	public void setDakehuDao(DakehuDao dakehuDao) {
		this.dakehuDao = dakehuDao;
	}

	public int getShengyurenshu() {
		return shengyurenshu;
	}

	public void setShengyurenshu(int shengyurenshu) {
		this.shengyurenshu = shengyurenshu;
	}

	public int getNewpiaomianjia() {
		return newpiaomianjia;
	}

	public void setNewpiaomianjia(int newpiaomianjia) {
		this.newpiaomianjia = newpiaomianjia;
	}

	public int getNewshuifei() {
		return newshuifei;
	}

	public void setNewshuifei(int newshuifei) {
		this.newshuifei = newshuifei;
	}

	public int getNewshishou() {
		return newshishou;
	}

	public void setNewshishou(int newshishou) {
		this.newshishou = newshishou;
	}

	public String getNewbeizhu() {
		return newbeizhu;
	}

	public void setNewbeizhu(String newbeizhu) {
		this.newbeizhu = newbeizhu;
	}

	public double getNewzhichujine() {
		return newzhichujine;
	}

	public void setNewzhichujine(double newzhichujine) {
		this.newzhichujine = newzhichujine;
	}

	public double getNewlirun() {
		return newlirun;
	}

	public void setNewlirun(double newlirun) {
		this.newlirun = newlirun;
	}
}
