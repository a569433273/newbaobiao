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
@Component("xiugai")
public class xiugai extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	@Resource
	private DakehuDao dakehuDao;

	private String chupiaorenyuan = "";

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		chupiaorenyuan = (String) request.getSession().getAttribute("yuangong");

		Dakehu dakehu = dakehuDao
				.loadById(Integer.valueOf(searchInfo.getXid()));
		dakehu.setCaigoushang(searchInfo.getXcaigoushang());
		dakehu.setXingming(searchInfo.getXxingming());
		dakehu.setPnr(searchInfo.getXpnr());
		dakehu.setPiaohao(searchInfo.getXpiaohao());
		dakehu.setHangcheng(searchInfo.getXhangcheng());
		dakehu.setHangban(searchInfo.getXhangban());
		dakehu.setCangwei(searchInfo.getXcangwei());
		dakehu.setOrdid("AS"+searchInfo.getXchupiaoriqi()+searchInfo.getXordid().substring(10, 15));
		dakehu.setChengjiriqi(searchInfo.getXchengjiriqi());
		dakehu.setPiaomianjia(searchInfo.getXpiaomianjia());
		dakehu.setShuifei(searchInfo.getXshuifei());
		dakehu.setZhichujine(searchInfo.getXzhichujine());
		dakehu.setShishou(searchInfo.getXshishou());
		dakehu.setLirun(searchInfo.getXlirun());
		dakehu.setChupiaoriqi(searchInfo.getXchupiaoriqi());
		dakehu.setBeizhu(searchInfo.getXbeizhu());
		dakehu.setYewuyuan(chupiaorenyuan);
		dakehuDao.update(dakehu);
		return "success";
	}

	public xiugai() {

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}

}
