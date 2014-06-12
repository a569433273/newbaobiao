package com.liu.baobiao.action;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.liu.baobiao.dao.DakehuDao;
import com.liu.baobiao.model.Dakehu;
import com.liu.baobiao.util.TimeZhuan;
import com.liu.baobiao.util.CaigoushangZhuan;
import com.liu.baobiao.util.Ordid;
import com.liu.baobiao.vo.searchInfo;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("dakehu")
@Scope("prototype")
public class dakehu extends ActionSupport implements ModelDriven<Object> {

	private Dakehu dakehu;
	private DakehuDao dakehuDao;

	private searchInfo searchInfo = new searchInfo();
	private Ordid GetOrdid = new Ordid();

	private List<String> xingming = new ArrayList<String>();
	private List<String> piaohao = new ArrayList<String>();
	private List<String> hangcheng = new ArrayList<String>();
	private List<String> hangban = new ArrayList<String>();
	private List<String> chengjiriqi = new ArrayList<String>();
	private List<String> chupiaojia = new ArrayList<String>();
	private List<String> shuifei = new ArrayList<String>();

	// 采购商、实际收款、利润、人数、pnr、航空公司、舱位、支出金额
	private String caigoushang = "";
	private String shishou = "";
	private String lirun = "";
	private String renshu = "1";
	private String pnr = "";
	private String hangkonggongsi = "";
	private String cangwei = "Y";
	private String zhichujine = "100";
	private String ordid = "";

	// 存姓名、存票号、存乘机日期
	private String cunxingming = "";
	private String cunppiaohao = "";
	private String cunchengjiriqi = "";

	private String chupiaorenyuan = "";

	// 错误信息
	private String cuowumessage = "";

	private Calendar calendar = Calendar.getInstance();

	@Override
	public String execute() throws Exception {

		// 将登陆人名存到session
		HttpServletRequest request = ServletActionContext.getRequest();
		chupiaorenyuan = (String) request.getSession().getAttribute("yuangong");
		request.getSession().setMaxInactiveInterval(-1);

		zhengze(xingming,
				"1.*\\s[H-J].{5}\\s|1.*\r\n.*\\s[H-J].{5}\\s|1.*\r\n.*\r\n.*\\s[H-J].{5}\\s");

		if (xingming.size() == 0) {
			cuowumessage = "哇，人名都没有就做表";
			return "faild";
		}
		String xingmingwithoutspace = xingming.get(0).trim();
		String cunxingmingtemp = xingmingwithoutspace.substring(0,
				xingmingwithoutspace.length() - 6).trim();

		cunxingming = cunxingmingtemp.replaceAll("\r\n", "");

		for (int i = 2; i < 10; i++) {
			if (cunxingmingtemp.contains(String.valueOf(i))) {
				renshu = String.valueOf(i);
			}
		}

		pnr = xingmingwithoutspace.substring(xingmingwithoutspace.length() - 6,
				xingmingwithoutspace.length()).trim();

		shishou = GetOrdid.Ordids(pnr,searchInfo.getOrdid())[1];

		switchcaigoushang();

		zhengze(chengjiriqi, "\\d{2}[A-Z]{3}");
		if (chengjiriqi.size() == 0) {
			cuowumessage = "哇，这次换乘机日期没有了";
			return "faild";
		}

		zhengze(hangban, "[A-Z][A-Z]\\d{3}\\s\\s[A-Z]|[A-Z][A-Z]\\d{4}\\s[A-Z]");
		if (hangban.size() == 0) {
			cuowumessage = "缺乏航班的报表不是好报表";
			return "faild";
		}
		cangwei = hangban.get(0).substring(hangban.get(0).length() - 1,
				hangban.get(0).length());

		String hangbantemp = hangban.get(0).substring(0,
				hangban.get(0).length() - 2);
		hangban.set(0, hangbantemp);

		hangkonggongsi = hangban.get(0).substring(0, 2);

		zhengze(hangcheng, "\\s[A-Z]{6}\\s");
		if (hangcheng.size() == 0) {
			cuowumessage = "客人是从哪里飞哪里呢？没航程啊！";
			return "faild";
		}
		zhengze(piaohao, "\\s\\d{13}");
		if (piaohao.size() == 0) {
			cuowumessage = "看看票号项，我知道你没有";
			return "faild";
		}

		// 输出的票号连起来
		if (piaohao.size() > 1) {
			cunppiaohao = piaohao.get(piaohao.size() - 1) + "-"
					+ piaohao.get(0).substring(10, 13);
		} else {
			cunppiaohao = piaohao.get(0);
		}

		zhengze(chupiaojia,
				"[F][C][N][Y]\\d{5}|[F][C][N][Y]\\d{4}|[F][C][N][Y]\\d{3}");
		if (chupiaojia.size() == 0) {
			cuowumessage = "请复制出票价格";
			return "faild";
		}
		String chupiaojia_every = chupiaojia.get(0).substring(4,
				chupiaojia.get(0).length());
		String chupiaojia_total = String.valueOf(Integer
				.valueOf(chupiaojia_every) * Integer.valueOf(renshu));
		chupiaojia.set(0, chupiaojia_total);

		zhengze(shuifei, "[X][C][N][Y]\\d{3}|[X][C][N][Y]\\d{2}");
		if (shuifei.size() == 0) {
			cuowumessage = "请复制税费";
			return "faild";
		}
		String shuifei_every = shuifei.get(0).substring(4,
				shuifei.get(0).length());
		String shuifei_total = String.valueOf(Integer.valueOf(shuifei_every)
				* Integer.valueOf(renshu));
		shuifei.set(0, shuifei_total);

		formatjine();

		switchcunchengjiriqi();

		if (dakehuDao.findBypnr(pnr).size() > 0) {
			cuowumessage = "这个PNR已经做过表了";
			return "faild";
		}

		// 出票日期
		DateFormat timedf = new SimpleDateFormat("yyyyMMdd");
		String time = timedf.format(calendar.getTime());

		ordid = "AS" + time + GetOrdid.Ordids(pnr,searchInfo.getOrdid())[0];
		savedakehu(time);

		return "success";
	}

	/**
	 * 支出金额格式化为小数点后保留两位
	 * 
	 * @author 刘健
	 */
	private void formatjine() {
		DecimalFormat df = new DecimalFormat("#.00");
		double a = Integer.valueOf(chupiaojia.get(0)) * 0.97;
		zhichujine = df.format(a + Integer.valueOf(shuifei.get(0)));

		lirun = df.format(Integer.valueOf(shishou)
				- (a + Integer.valueOf(shuifei.get(0))));
	}

	private void savedakehu(String time) {
		Dakehu dakehu = new Dakehu();
		dakehu.setCaigoushang(caigoushang);
		dakehu.setXingming(cunxingming);
		dakehu.setPnr(pnr);
		dakehu.setPiaohao(cunppiaohao);
		dakehu.setHangcheng(hangcheng.get(1));
		dakehu.setHangban(hangban.get(0));
		dakehu.setCangwei(cangwei);
		dakehu.setChengjiriqi(cunchengjiriqi);
		dakehu.setPiaomianjia(chupiaojia.get(0));
		dakehu.setShuifei(shuifei.get(0));
		dakehu.setZhichujine(zhichujine);
		dakehu.setShishou(shishou);
		dakehu.setLirun(lirun);
		dakehu.setChupiaoriqi(time);
		dakehu.setHangkonggongsi(hangkonggongsi);
		dakehu.setRenshu(renshu);
		dakehu.setFeipiaorenshu("0");
		dakehu.setYewuyuan(chupiaorenyuan);
		dakehu.setOrdid(ordid);
		dakehu.setKehumanager("dakehu");
		dakehuDao.save(dakehu);
	}

	/**
	 * 日期转换方法
	 * 
	 * @author 刘健
	 * @param 根据PNRmessage得到的英文转换为中文时间
	 */
	private void switchcunchengjiriqi() {
		String yuefen = chengjiriqi.get(0).substring(2, 5);
		String riqi = chengjiriqi.get(0).substring(0, 2);

		switch (TimeZhuan.getTimezhuan(yuefen)) {
		case JAN:
			cunchengjiriqi = "1月" + riqi + "日";
			break;
		case FEB:
			cunchengjiriqi = "2月" + riqi + "日";
			break;
		case MAR:
			cunchengjiriqi = "3月" + riqi + "日";
			break;
		case APR:
			cunchengjiriqi = "4月" + riqi + "日";
			break;
		case MAY:
			cunchengjiriqi = "5月" + riqi + "日";
			break;
		case JUN:
			cunchengjiriqi = "6月" + riqi + "日";
			break;
		case JUL:
			cunchengjiriqi = "7月" + riqi + "日";
			break;
		case AUG:
			cunchengjiriqi = "8月" + riqi + "日";
			break;
		case SEP:
			cunchengjiriqi = "9月" + riqi + "日";
			break;
		case OCT:
			cunchengjiriqi = "10月" + riqi + "日";
			break;
		case NOV:
			cunchengjiriqi = "11月" + riqi + "日";
			break;
		case DEC:
			cunchengjiriqi = "12月" + riqi + "日";
			break;
		default:
			break;
		}
	}

	/**
	 * 采购商转换方法
	 * 
	 * @author 刘健
	 * @param 根据网页返回值得到采购商名称
	 */
	private void switchcaigoushang() {
		String name = GetOrdid.Ordids(pnr,searchInfo.getOrdid())[2];
		switch (CaigoushangZhuan.getcaigoushang(name)) {
		case pfzlplj220:
			caigoushang = "张禄萍";
			break;
		case pfkuangxionghui:
			caigoushang = "邝雄辉";
			break;
		case pfwhq:
			caigoushang = "王海芹";
			break;
		case pfztpw:
			caigoushang = "王海生";
			break;
		case pfwanghailin:
			caigoushang = "王海林";
			break;
		case pfwuhjsl:
			caigoushang = "金士力";
			break;
		case pfnewsky888:
			caigoushang = "新天空";
			break;
		case pfnewsky2:
			caigoushang = "新天空2";
			break;
		case pfshouhang:
			caigoushang = "吴德生";
			break;
		case pfwuh164:
			caigoushang = "盛亚辉";
			break;
		default:
			break;
		}
	}

	public dakehu() {

	}

	/**
	 * 正则表达式通用方法
	 * 
	 * @author 刘健
	 * @param list
	 *            存储正则表达式结果的列表
	 * @param zzbiaodashi
	 *            匹配的正则表达式
	 */
	private void zhengze(List<String> list, String zzbiaodashi) {
		String PNRmessage = searchInfo.getPNRmessage();
		Pattern pattern = Pattern.compile(zzbiaodashi);
		Matcher matcher = pattern.matcher(PNRmessage);
		list.clear();
		while (matcher.find()) {
			list.add(matcher.group().trim());
		}
	}

	@Override
	public Object getModel() {
		return searchInfo;
	}

	public searchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(searchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}

	public List<String> getPiaohao() {
		return piaohao;
	}

	public void setPiaohao(List<String> piaohao) {
		this.piaohao = piaohao;
	}

	public List<String> getHangban() {
		return hangban;
	}

	public void setHangban(List<String> hangban) {
		this.hangban = hangban;
	}

	public List<String> getXingming() {
		return xingming;
	}

	public void setXingming(List<String> xingming) {
		this.xingming = xingming;
	}

	public List<String> getChupiaojia() {
		return chupiaojia;
	}

	public void setChupiaojia(List<String> chupiaojia) {
		this.chupiaojia = chupiaojia;
	}

	public List<String> getHangcheng() {
		return hangcheng;
	}

	public void setHangcheng(List<String> hangcheng) {
		this.hangcheng = hangcheng;
	}

	public List<String> getChengjiriqi() {
		return chengjiriqi;
	}

	public void setChengjiriqi(List<String> chengjiriqi) {
		this.chengjiriqi = chengjiriqi;
	}

	public String getCangwei() {
		return cangwei;
	}

	public void setCangwei(String cangwei) {
		this.cangwei = cangwei;
	}

	public List<String> getShuifei() {
		return shuifei;
	}

	public void setShuifei(List<String> shuifei) {
		this.shuifei = shuifei;
	}

	public String getZhichujine() {
		return zhichujine;
	}

	public void setZhichujine(String zhichujine) {
		this.zhichujine = zhichujine;
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

	public String getCcprq() {
		return cunchengjiriqi;
	}

	public void setCcprq(String ccprq) {
		this.cunchengjiriqi = ccprq;
	}

	public String getLr() {
		return lirun;
	}

	public void setLr(String lr) {
		this.lirun = lr;
	}

	public String getSs() {
		return shishou;
	}

	public void setSs(String ss) {
		this.shishou = ss;
	}

	public String getCcjrq() {
		return cunchengjiriqi;
	}

	public void setCcjrq(String ccjrq) {
		this.cunchengjiriqi = ccjrq;
	}

	public String getCgs() {
		return caigoushang;
	}

	public void setCgs(String cgs) {
		this.caigoushang = cgs;
	}

	public String getCuowumessage() {
		return cuowumessage;
	}

	public void setCuowumessage(String cuowumessage) {
		this.cuowumessage = cuowumessage;
	}
}
