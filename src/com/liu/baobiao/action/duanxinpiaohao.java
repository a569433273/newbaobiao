package com.liu.baobiao.action;

import java.util.Iterator;

import javax.annotation.Resource;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;
import org.tempuri.Service;

import com.liu.baobiao.dao.FlightnameDao;
import com.liu.baobiao.vo.searchInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
@Component("duanxinpiaohao")
public class duanxinpiaohao extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	private FlightnameDao flightnameDao;

	private String duanxin = "";

	@Override
	public String execute() throws Exception {
		duanxin = "";
		String identity = "<?xml version='1.0' encoding='utf-8'?><Identity_1_0><ABEConnectionString>User=liujian;Password=123456;Server=119.161.188.35;Port=350;MaxPages=20;</ABEConnectionString></Identity_1_0>";
		String request = "<?xml version='1.0'?><ABE_DETR_1_0><TicketNo>"
				+ searchInfo.getDuanxinmessage() + "</TicketNo></ABE_DETR_1_0>";
		String filter = "";
		Service service = new Service();
		String returnString = service.getServiceSoap().abeSubmit(identity,
				request, filter);
		try {
			Document document = DocumentHelper.parseText(returnString);
			Element rootElement = document.getRootElement();

			Element renming = rootElement.element("Passenger");

			Element piaohao = rootElement.element("TicketNo");

			Element flightElement = rootElement.element("Flights").element(
					"Flight");
			Attribute hangkonggongsi = flightElement.attribute("Carrier");
			Attribute hangkonggongsich = flightElement.attribute("CarrierName");
			Attribute hangbanhao = flightElement.attribute("Flight");
			Attribute hangbanshijian = flightElement.attribute("DepartureDate"); // 5,7是月份,8-10是日期
			Attribute qifeihangzhanlou = flightElement
					.attribute("BoardPointAT");
			Attribute daodahangzhanlou = flightElement.attribute("OffpointAT");
			if (daodahangzhanlou.getText().equals("--")) {
				daodahangzhanlou.setText("");
			}
			Attribute qifeishijian = flightElement.attribute("DepartureTime");

			Element qifei = rootElement.element("ORG");
			if (qifei.getText().equals("BJS")) {
				qifei.setText("PEK");
			}
			Element daoda = rootElement.element("DST");

			String qifeijichang = flightnameDao.findbysanzima(qifei.getText()).getJichang();

			String daodajichang = flightnameDao.findbysanzima(daoda.getText()).getJichang();

			String zongjia = "";
			Element zongjiarootElement = rootElement.element("FN");
			for (Iterator it = zongjiarootElement.elementIterator(); it
					.hasNext();) {
				Element zongjiaElement = (Element) it.next();
				if (zongjiaElement.attribute("Type").getText().equals("A")) {
					zongjia = zongjiaElement.attribute("Value").getText().substring(0, zongjiaElement.attribute("Value").getText().length() -3);
				}
			}

			duanxin += renming.getText() + hangkonggongsich.getText()
					+ hangkonggongsi.getText() + hangbanhao.getText() + " "
					+ hangbanshijian.getText().substring(5, 7) + "月"
					+ hangbanshijian.getText().substring(8, 10) + "日"
					+ qifeijichang + qifeihangzhanlou.getText() + "("
					+ qifeishijian.getText() + "起飞)-" + daodajichang
					+ daodahangzhanlou.getText() + "已出票，票号" + piaohao.getText()
					+ ",总价￥" + zongjia + ",祝旅途愉快!";
			System.out.println(duanxin);
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

	public duanxinpiaohao() {
	}

	public searchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(searchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}

	public FlightnameDao getFlightnameDao() {
		return flightnameDao;
	}

	@Resource
	public void setFlightnameDao(FlightnameDao flightnameDao) {
		this.flightnameDao = flightnameDao;
	}

	public String getDuanxin() {
		return duanxin;
	}

	public void setDuanxin(String duanxin) {
		this.duanxin = duanxin;
	}

}
