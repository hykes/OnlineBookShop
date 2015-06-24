package cn.jxufe.web.entity;

/**
 * 
* 类名称：Admin   
* 类描述： 管理员
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:15:19     
* 修改备注：   
* @version
 */
public class Admin {

	private Integer id; //主键
	
	private String username; //登录名
	
	private String password;//登录密码
	
	private String cnname; //中文名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

}
