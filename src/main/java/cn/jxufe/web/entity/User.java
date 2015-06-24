package cn.jxufe.web.entity;

import java.util.Date;

/**
 * 
* 类名称：User   
* 类描述：用户类 
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:15:43     
* 修改备注：   
* @version
 */
public class User {

	private Integer id; //主键
	
	private String username; //登录名
	
	private String password;//登录密码
	
	private String cnname; //中文名称
	
	private Date createTime; //注册时间
	
	private String email; // 邮箱
	
	private String address; // 住址
	
	private String phone; // 电话

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
