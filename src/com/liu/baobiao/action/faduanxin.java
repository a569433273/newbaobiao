package com.liu.baobiao.action;

import java.net.URL;
import java.net.URLEncoder;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import com.liu.baobiao.vo.searchInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
@Component("faduanxin")
public class faduanxin extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	private String duanxin = "";

	@Override
	public String execute() throws Exception {
		duanxin = "";
		String qurl = "http://211.147.244.114:9801/CASServer/SmsAPI/SendMessage.jsp?userid=83497&password=nestpu"
				+ "&destnumbers="
				+ searchInfo.getShoujihao()
				+ "&msg="
				+ URLEncoder.encode(searchInfo.getDuanxinmessage(), "UTF-8")
				+ "&sendtime=";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new URL(qurl));
		if ("0".endsWith(document.valueOf("/root/@return"))) {
			duanxin = "·¢ËÍ³É¹¦";
		}
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}

	public String getDuanxin() {
		return duanxin;
	}

	public void setDuanxin(String duanxin) {
		this.duanxin = duanxin;
	}
}
