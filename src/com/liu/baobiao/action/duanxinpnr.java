package com.liu.baobiao.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;
import org.tempuri.Service;

import com.liu.baobiao.dao.FlightnameDao;
import com.liu.baobiao.dao.HangkonggsDao;
import com.liu.baobiao.vo.searchInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
@Component("duanxinpnr")
public class duanxinpnr extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	@Resource
	private HangkonggsDao hangkonggsDao;
	@Resource
	private FlightnameDao flightnameDao;

	private String duanxin = "";

	@Override
	public String execute() throws Exception {
		duanxin = "";
		String identity = "<?xml version='1.0' encoding='utf-8'?><Identity_1_0><ABEConnectionString>User=liujian;Password=123456;Server=119.161.188.35;Port=350;MaxPages=20;</ABEConnectionString></Identity_1_0>";
		String request = "<?xml version='1.0' encoding='UTF-8'?><ABE_RTPNR_1_0><PNR>"
				+ searchInfo.getDuanxinmessage().trim()
				+ "</PNR><XmlVersion>3.0</XmlVersion></ABE_RTPNR_1_0>";
		String filter = "";
		Service service = new Service();
		String returnString = service.getServiceSoap().abeSubmit(identity,
				request, filter);
		try {
			Document document = DocumentHelper.parseText(returnString);
			Element rootElement = document.getRootElement();

			List<String> piaohao = new ArrayList<String>();

			Element passengers = rootElement.element("Passengers");
			for (Iterator it = passengers.elementIterator(); it.hasNext();) {
				Element ssElement = (Element) it.next();
				duanxin += ssElement.attribute("Name").getText();
				duanxin += ssElement.attribute("CardNo").getText();
				piaohao.add(ssElement.attribute("TicketNo").getText());
			}
			Element flightElement = rootElement.element("Flights").element(
					"Flight");
			Attribute hangkonggongsi = flightElement.attribute("Carrier");
			String hangkonggongsiname = hangkonggsDao.fingbycode(
					hangkonggongsi.getText()).getJiancheng();

			Attribute hangbanhao = flightElement.attribute("Flight");
			Attribute hangbanshijian = flightElement.attribute("DepartureDate"); // 5,7是月份,8-10是日期

			Attribute qifei = flightElement.attribute("BoardPoint");
			if (qifei.getText().equals("BJS")) {
				qifei.setText("PEK");
			}
			Attribute daoda = flightElement.attribute("OffPoint");

			String qifeijichang = flightnameDao.findbysanzima(qifei.getText())
					.getJichang();
			String daodajichang = flightnameDao.findbysanzima(daoda.getText())
					.getJichang();

			Attribute qifeihangzhanlou = flightElement
					.attribute("BoardPointAT");
			Attribute daodahangzhanlou = flightElement.attribute("OffpointAT");
			if (daodahangzhanlou.getText().equals("-")) {
				daodahangzhanlou.setText("");
			}
			Attribute qifeishijian = flightElement.attribute("DepartureTime");
			String zongjia = "";
			Element zongjiarootElement = rootElement.element("FNs").element(
					"FN");
			for (Iterator it = zongjiarootElement.elementIterator(); it
					.hasNext();) {
				Element zongjiaElement = (Element) it.next();
				if (zongjiaElement.attribute("Type").getText().equals("A")) {
					zongjia = String.valueOf(Integer.valueOf(zongjiaElement
							.attribute("Value")
							.getText()
							.substring(
									0,
									zongjiaElement.attribute("Value").getText()
											.length() - 3))
							* piaohao.size());
				}
			}
			duanxin += hangkonggongsiname + hangkonggongsi.getText()
					+ hangbanhao.getText() + " "
					+ hangbanshijian.getText().substring(5, 7) + "月"
					+ hangbanshijian.getText().substring(8, 10) + "日"
					+ qifeijichang + qifeihangzhanlou.getText() + "("
					+ qifeishijian.getText() + "起飞)-" + daodajichang
					+ daodahangzhanlou.getText() + "已出票，票号";
			// + ",总价￥" + zongjia + ",祝旅途愉快!窠浦航空";
			for (int i = 0; i < piaohao.size(); i++) {
				duanxin += piaohao.get(i) + ",";
			}
			duanxin += ",总价￥" + zongjia + ",祝旅途愉快!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}

	public duanxinpnr() {
	}

	public String getDuanxin() {
		return duanxin;
	}

	public void setDuanxin(String duanxin) {
		this.duanxin = duanxin;
	}

}
