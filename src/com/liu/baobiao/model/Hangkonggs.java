package com.liu.baobiao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hangkonggs {

	private String code;
	private String gongsiname;
	private String jiancheng;

	@Id
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGongsiname() {
		return gongsiname;
	}

	public void setGongsiname(String gongsiname) {
		this.gongsiname = gongsiname;
	}

	public String getJiancheng() {
		return jiancheng;
	}

	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}
}
