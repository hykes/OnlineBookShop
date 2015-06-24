package cn.jxufe.web.home.service;

import cn.jxufe.web.entity.User;

public interface LoginRegisterService {

	public abstract int loginCheck(String username, String password);

	public long queryUsername(String username);
	public int register(String username, String password, String cnname) throws Exception;
	public User queryUserInfo(String username);
}