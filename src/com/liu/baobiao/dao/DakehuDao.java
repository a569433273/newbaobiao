package com.liu.baobiao.dao;

import java.util.List;

import com.liu.baobiao.model.Dakehu;

public interface DakehuDao {
	public void save(Dakehu dakehu);
	public void delete(Dakehu dakehu);
	public void update(Dakehu dakehu);
	
	public List<Dakehu> getdakehu();
	public List<Dakehu> findBypnr(String pnr);
	public List<Dakehu> findByordid(String ordid);
	public List<Dakehu> findBychupiaoriqiandhangkonggongsi(String chupiaoriqi,String hangkonggongsi);
	public List<Dakehu> findBycaigoushang(String caigoushang);
	
	public Dakehu loadById(int id);
}
