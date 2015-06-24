package cn.jxufe.web.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.User;
import cn.jxufe.web.entity.Page;

@Service
public  class UserServiceImpl implements UserService {
	
	@Autowired
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#insertUser(cn.jxufe.web.entity.User)
	 */
	public int insertUser(User user) throws Exception{
		String sql = "insert into t_user(username,passwrod,cnname,createTime,email,address,phone) values(?,?,?,now(),?,?,?)";
		Object[] args=new Object[]{ user.getUsername(), user.getPassword(), user.getCnname(), user.getEmail(), user.getAddress(), user.getPhone() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#updateUser(cn.jxufe.web.entity.User)
	 */
	public int updateUser(User user) throws Exception{
		String sql = "update t_user set cnname=?,email=?,phone=?,address=?  where id=?";
		Object[] args=new Object[]{ user.getCnname(), user.getEmail(),  user.getPhone(), user.getAddress(), user.getId() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#deleteUser(java.lang.Integer)
	 */
	public int deleteUser(Integer id) throws Exception{
		String sql = "delete from t_user where id=?";
		Object[] args=new Object[]{ id };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#queryUser(java.lang.Integer)
	 */
	public User queryUser(Integer id){
		String sql = "select * from t_user where id = ? ";
		Object[] args = new Object[] { id };
		return  (User) baseDao.findUniqueBeanByArray(sql, User.class, args);
	}

	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#getUserPage(cn.jxufe.web.entity.Page)
	 */
	public Page getUserPage(Page page){
		String sql = "select * from t_user";
		Object[] args = new Object[] {  };
		return baseDao.findPageListByArray(page, User.class, sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#getUserList()
	 */
	public List<User> getUserList(){
		String sql = "select * from t_user";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, User.class, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.UserService#updatePwd()
	 */
	public int updateAdminPwd(Integer id, String newpassword, String password) throws Exception{
		String sql = "update t_admin set password=? where id=? and password=?";
		Object[] args=new Object[]{ newpassword, id, password };
		return baseDao.executeByArray(sql, args);
	}
	
	public int updateUserPwd(Integer id, String newpassword) throws Exception{
		String sql = "update t_user set password=? where id=?";
		Object[] args=new Object[]{ newpassword, id };
		return baseDao.executeByArray(sql, args);
	}
}
