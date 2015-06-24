package cn.jxufe.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.Admin;
import cn.jxufe.web.entity.User;

@Service
public  class SystemServiceImpl implements SystemService {
	
	@Autowired
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.SystemService#getBookCount()
	 */
	@Override
	public long getBookCount(){
		String sql="select count(*) from t_book";
		Object[] args=new Object[]{ };
		return baseDao.findLongByArray(sql, args);
	}
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.SystemService#getUserCount()
	 */
	@Override
	public long getUserCount(){
		String sql="select count(*) from t_user";
		Object[] args=new Object[]{ };
		return baseDao.findLongByArray(sql, args);
	}
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.SystemService#getOrderCount()
	 */
	@Override
	public long getOrderCount(){
		String sql="select count(*) from t_order";
		Object[] args=new Object[]{ };
		return baseDao.findLongByArray(sql, args);
	}
	
	public int loginCheck(String username, String password){
		String sql = "select count(*) from t_admin where username=?";
		long count= baseDao.findLongByArray(sql, username);
		if (count > 0) {
			sql="select count(*) from t_admin where username=? and password=?";
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
	
	public Admin queryAdminInfo(String username){
		String sql = "select * from t_admin where username = ? ";
		Object[] args = new Object[] { username };
		return  (Admin) baseDao.findUniqueBeanByArray(sql, Admin.class, args);
	}
	
}
