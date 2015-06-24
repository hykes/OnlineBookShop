package cn.jxufe.web.admin.service;

import cn.jxufe.web.entity.Admin;
import cn.jxufe.web.entity.User;

public interface SystemService {

	public abstract long getBookCount();

	public abstract long getUserCount();

	public abstract long getOrderCount();
	
	public abstract int loginCheck(String username, String password);
	
	public Admin queryAdminInfo(String username);

}