package cn.jxufe.web.admin.service;

import java.util.List;

import cn.jxufe.web.entity.Page;
import cn.jxufe.web.entity.User;

public interface UserService {

	public abstract int insertUser(User user) throws Exception;

	public abstract int updateUser(User user) throws Exception;

	public abstract int deleteUser(Integer id) throws Exception;

	public abstract User queryUser(Integer id);

	public abstract Page getUserPage(Page page);

	public abstract List<User> getUserList();
	
	public int updateAdminPwd(Integer id, String newpassword, String password) throws Exception;
	
	public int updateUserPwd(Integer id, String newpassword) throws Exception;

}