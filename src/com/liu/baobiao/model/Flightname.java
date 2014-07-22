package com.liu.baobiao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flightname {

	private String B;
	private String sanzima;
	private String jichang;

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

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
}
