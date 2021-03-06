package com.liu.baobiao.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.liu.baobiao.vo.searchInfo;
import com.liu.baobiao.dao.UserDao;
import com.liu.baobiao.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("denglu")
public class denglu extends ActionSupport implements ModelDriven<Object> {

	private searchInfo searchInfo = new searchInfo();

	@Resource
	private UserDao userDao;

	@Override
	public String execute() throws Exception {
		User user = userDao.findByusername(searchInfo.getUsername());
		HttpServletRequest request = ServletActionContext.getRequest();

		String yuangong = user.getYuangong();
		request.getSession().setAttribute("yuangong", yuangong);
		request.getSession().setMaxInactiveInterval(-1);

		searchInfo.setUsername(null);

		if (searchInfo.getPassword() == "") {
			return "faild";
		}

		if (user.getPassword().equalsIgnoreCase(searchInfo.getPassword())) {
			return "success";
		} else {
			return "faild";
		}
	}

	public denglu() {

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}
}
