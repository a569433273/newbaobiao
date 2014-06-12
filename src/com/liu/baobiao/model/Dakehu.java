package com.liu.baobiao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dakehu {

	private int id;
	private String caigoushang;
	private String xingming;
	private String pnr;
	private String piaohao;
	private String hangcheng;
	private String hangban;
	private String cangwei;
	private String chengjiriqi;
	private String piaomianjia;
	private String shuifei;
	private String zhichujine;
	private String shishou;
	private String lirun;
	private String chupiaoriqi;
	private String hangkonggongsi;
	private String beizhu;
	private String renshu;
	private String feipiaorenshu;
	private String yewuyuan;
	private String ordid;
	private String kehumanager;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaigoushang() {
		return caigoushang;
	}

	public void setCaigoushang(String caigoushang) {
		this.caigoushang = caigoushang;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getPiaohao() {
		return piaohao;
	}

	public void setPiaohao(String piaohao) {
		this.piaohao = piaohao;
	}

	public String getHangcheng() {
		return hangcheng;
	}

	public void setHangcheng(String hangcheng) {
		this.hangcheng = hangcheng;
	}

	public String getHangban() {
		return hangban;
	}

	public void setHangban(String hangban) {
		this.hangban = hangban;
	}

	public String getCangwei() {
		return cangwei;
	}

	public void setCangwei(String cangwei) {
		this.cangwei = cangwei;
	}

	public String getChengjiriqi() {
		return chengjiriqi;
	}

	public void setChengjiriqi(String chengjiriqi) {
		this.chengjiriqi = chengjiriqi;
	}

	public String getPiaomianjia() {
		return piaomianjia;
	}

	public void setPiaomianjia(String piaomianjia) {
		this.piaomianjia = piaomianjia;
	}

	public String getShuifei() {
		return shuifei;
	}

	public void setShuifei(String shuifei) {
		this.shuifei = shuifei;
	}

	public String getZhichujine() {
		return zhichujine;
	}

	public void setZhichujine(String zhichujine) {
		this.zhichujine = zhichujine;
	}

	public String getShishou() {
		return shishou;
	}

	public void setShishou(String shishou) {
		this.shishou = shishou;
	}

	public String getLirun() {
		return lirun;
	}

	public void setLirun(String lirun) {
		this.lirun = lirun;
	}

	public String getChupiaoriqi() {
		return chupiaoriqi;
	}

	public void setChupiaoriqi(String chupiaoriqi) {
		this.chupiaoriqi = chupiaoriqi;
	}

	public String getHangkonggongsi() {
		return hangkonggongsi;
	}

	public void setHangkonggongsi(String hangkonggongsi) {
		this.hangkonggongsi = hangkonggongsi;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getRenshu() {
		return renshu;
	}

	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}

	public String getFeipiaorenshu() {
		return feipiaorenshu;
	}

	public void setFeipiaorenshu(String feipiaorenshu) {
		this.feipiaorenshu = feipiaorenshu;
	}

	public String getYewuyuan() {
		return yewuyuan;
	}

	public void setYewuyuan(String yewuyuan) {
		this.yewuyuan = yewuyuan;
	}

	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

	public String getKehumanager() {
		return kehumanager;
	}

	public void setKehumanager(String kehumanager) {
		this.kehumanager = kehumanager;
	}

}
