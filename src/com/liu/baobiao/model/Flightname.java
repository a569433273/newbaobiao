package com.liu.baobiao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flightname {

	private String sanzima;
	private String jichang;
	private String chengshi;

	@Id
	public String getSanzima() {
		return sanzima;
	}

	public void setSanzima(String sanzima) {
		this.sanzima = sanzima;
	}

	public String getJichang() {
		return jichang;
	}

	public void setJichang(String jichang) {
		this.jichang = jichang;
	}

	public String getChengshi() {
		return chengshi;
	}

	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}
}
