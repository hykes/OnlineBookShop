package cn.jxufe.web.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.User;

@Service
public  class LoginRegisterServiceImpl implements LoginRegisterService {
	
	@Autowired
	public BaseDao baseDao;
	
	public int loginCheck(String username, String password){
		String sql = "select count(*) from t_user where username=?";
		long count= baseDao.findLongByArray(sql, username);
		if (count > 0) {
			sql="select count(*) from t_user where username=? and password=?";
			count=baseDao.findLongByArray(sql, username, password);
			if (count > 0) {
				return 1;
			} else {
				return -2;
			}
		}
		else{
			return -1;
		}
	}
	
	public long queryUsername(String username){
		String sql = "select count(*) from t_user where username=?";
		long count= baseDao.findLongByArray(sql, username);
		return count;
	}
	
	public int register(String username, String password, String cnname) throws Exception{
		String sql = "insert into t_user(username,password, cnname, createTime) values(?,?,?,now())"; 
		Object[] args=new Object[]{ username, password, cnname};
		return baseDao.executeByArray(sql, args);
	}
	
	public User queryUserInfo(String username){
		String sql = "select * from t_user where username = ? ";
		Object[] args = new Object[] { username };
		return  (User) baseDao.findUniqueBeanByArray(sql, User.class, args);
	}
	
	

}
