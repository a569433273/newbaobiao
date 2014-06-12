package com.liu.baobiao.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Ordid {
	public String[] Ordids(String PNR,String Order) {
		String[] ordid = new String[3];
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			String body = "";
			HttpResponse response;
			HttpEntity entity;
			HttpPost httpPost = new HttpPost(
					"http://www.nestpu.cn/plane2/login.action?");// 一定要改成可以提交的地址,这里用百度代替
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("loginName", "admin"));// 名值对
			nvps.add(new BasicNameValuePair("password", "nestpu123"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			response = httpclient.execute(httpPost);
			entity = response.getEntity();
			body = EntityUtils.toString(entity);
			httpPost.abort();
			httpPost.releaseConnection();

			HttpPost httpPost1 = new HttpPost(
					"http://www.nestpu.cn/plane2/order/cust/ticketOrderListAction.action?");// 一定要改成可以提交的地址,这里用百度代替
			List<NameValuePair> nvps1 = new ArrayList<NameValuePair>();
			if (Order.length() > 14) {
				nvps1.add(new BasicNameValuePair("orderSn", Order));
			}else {
			nvps1.add(new BasicNameValuePair("pnr", PNR));
			}
			httpPost1.setEntity(new UrlEncodedFormEntity(nvps1, Consts.UTF_8));
			response = httpclient.execute(httpPost1);
			entity = response.getEntity();
			body = EntityUtils.toString(entity);
			httpPost1.abort();
			Document doc = Jsoup.parse(body);

			Element dingdanhao = doc.select("[name=idRadio]").first();
			if (dingdanhao != null) {
				ordid[0] = dingdanhao.attr("value").substring(0, 5);
			} else {
				ordid[0] = "idcuowu";
			}
			
			if (doc.select("td").size() > 32) {
			Element shishou = doc.select("td").get(29);
			ordid[1] = shishou.text().substring(0, shishou.text().length()-1);
			
			Element caigoushang = doc.select("td").get(32);
			ordid[2] = caigoushang.text();
			} else {
				ordid[1] = "10000";
				ordid[2] = "新天空";
			}
			httpPost1.releaseConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ordid;
	}

}
