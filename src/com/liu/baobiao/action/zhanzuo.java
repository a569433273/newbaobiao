package com.liu.baobiao.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.liu.baobiao.vo.searchInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("zhanzuo")
public class zhanzuo extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();
	private List<String> hangban = new ArrayList<String>();
	private List<String> didian = new ArrayList<String>();
	private List<String> shijian = new ArrayList<String>();
	private List<String> renming = new ArrayList<String>();
	private List<String> shenfenzheng = new ArrayList<String>();
	private List<String> shenfenzhengzhen = new ArrayList<String>();
	private List<String> osinumber = new ArrayList<String>();

	private Calendar calendar = Calendar.getInstance();

	private String ssmessage = "";

	public String execute() throws Exception {

		String sshang = "ss";
		String nmhang = "nm";
		String ssrhang = "";
		String osihang = "";
		String shixianhang = "";
		String rmkhang = "";

		for (int i = 0; i < 10; i++) {
			shenfenzhengzhen.add(" ");
		}

		if (searchInfo.getOsinumber().equalsIgnoreCase("1")) {
			zhengze(osinumber, "\\s\\d{11}\\s");
			osinumber.set(0, osinumber.get(0).replaceAll("\\s", ""));
			zhengze(hangban, "[A-Z][A-Z]\\d{3,4}");
			sshang = sshang + hangban.get(0) + "Y";
			osihang = osihang + "osi " + hangban.get(0).substring(0, 2)
					+ " ctct" + osinumber.get(0);

			zhengze(shijian, "\\d{4}[-]\\d{2}[-]\\d{2}");

			String yuefen = shijianzhuanyuefen();

			sshang = sshang + shijian.get(0).substring(8, 10) + yuefen;

			zhengze(didian, "[A-Z]{3}");
			zhengze(renming,
					"[\u4e00-\u9fa5].*\\d{5}[X]\\t.\\d{1,4}|[A-Z].*\\d{5}\\t.\\d{1,4}|[\u4e00-\u9fa5].*\\d{5}\\t.\\d{1,4}");

			sshang = sshang + didian.get(0) + didian.get(1) + renming.size();

			for (int i = 0; i < renming.size(); i++) {
				String string = renming.get(i);
				String[] as = string.split("\t");
				nmhang = nmhang + "1" + as[0].trim();
				nmhang.trim();
				ssrhang = ssrhang + "ssr foid "
						+ hangban.get(0).substring(0, 2) + " hk/ni"
						+ as[3].substring(1, as[3].length()) + "/p" + (i + 1)
						+ "\n";
			}

			shixianhang = shixianhang();

			ssmessage = sshang + "\n" + nmhang.trim() + "\n" + ssrhang
					+ osihang + "\n" + shixianhang + "\\";
		} else {
			zhengze(hangban, "[A-Z][A-Z]\\d{3,4}");
			sshang = sshang + hangban.get(0) + "Y";

			zhengze(shijian, "\\d{2}[A-Z]{3}");

			zhengze(didian, "[A-Z]{6}\\s[H]");

			zhengze(renming, "[\u4e00-\u9fa5]{1,2}.\\s");

			sshang = sshang + shijian.get(0)
					+ didian.get(0).substring(0, didian.get(0).length() - 2)
					+ renming.size();

			for (int i = 0; i < renming.size(); i++) {
				nmhang = nmhang + "1" + renming.get(i);
			}

			zhengze(shenfenzheng,
					"\\d{18}..\\d|\\d{17}[X]..\\d|\\d{17}[x]..\\d");

			for (int i = 0; i < shenfenzheng.size(); i++) {
				int dijige = Integer.parseInt(shenfenzheng.get(i).substring(
						shenfenzheng.get(i).length() - 1,
						shenfenzheng.get(i).length()));
				shenfenzhengzhen.set(
						dijige - 1,
						shenfenzheng.get(i).substring(0,
								shenfenzheng.get(i).length() - 3));
			}

			if (shenfenzheng.size() != 0) {
				for (int i = 0; i < shenfenzheng.size(); i++) {
					ssrhang = ssrhang + "ssr foid "
							+ hangban.get(0).substring(0, 2) + " hk/ni"
							+ shenfenzhengzhen.get(i) + "/p" + (i + 1) + "\n";
				}
			} else {
				ssrhang = ssrhang + "ssr foid "
						+ hangban.get(0).substring(0, 2) + " hk/ni";
			}

			osihang = osihang + "osi " + hangban.get(0).substring(0, 2)
					+ " ctct" + searchInfo.getOsinumber().substring(0, 11);

			shixianhang = shixianhang();

			rmkhang = "rmk aj auth "
					+ searchInfo.getOsinumber().substring(11, 17);

			ssmessage = sshang + "\n" + nmhang.trim() + "\n" + ssrhang
					+ osihang + "\n" + shixianhang + "\n" + rmkhang + "\n"
					+ "\\";
		}
		shenfenzhengzhen.clear();
		return "success";
	}

	/**
	 * tktl生成
	 * 
	 * @author 刘健
	 */
	private String shixianhang() {
		String shixianhang;
		DateFormat timedf = new SimpleDateFormat("HH");
		String time = timedf.format(calendar.getTime());
		int a = Integer.parseInt(time);
		a = a + 3;
		shixianhang = "tktl/" + String.valueOf(a) + "00/./pek460";
		return shixianhang;
	}

	/**
	 * 网页时间类似04转成英文通用方法
	 * 
	 * @author 刘健
	 */
	private String shijianzhuanyuefen() throws ParseException {
		String yuefen = shijian.get(0).substring(5, 7);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
		Date date = simpleDateFormat.parse(yuefen);
		simpleDateFormat = new SimpleDateFormat("MMMM", Locale.US);
		yuefen = simpleDateFormat.format(date).substring(0, 3);
		return yuefen;
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
		String creatPNRmessage = searchInfo.getCreatPNRmessage();
		Pattern pattern = Pattern.compile(zzbiaodashi);
		Matcher matcher = pattern.matcher(creatPNRmessage);
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

	public String getSsmessage() {
		return ssmessage;
	}

	public void setSsmessage(String ssmessage) {
		this.ssmessage = ssmessage;
	}

}
