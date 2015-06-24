package cn.jxufe.web.entity;

import java.util.Date;

/**
 * 
* 类名称：Order   
* 类描述： 订单类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:27:50     
* 修改备注：   
* @version
 */
public class Order {

	private Integer id; //主键
	
	private Date createTime;
	
	private Double total; //总计
	
	private Integer status; //订单状态：1未付款, 2已付款但未发货, 3已发货未确认收货, 4确认收货了交易成功, 5已取消(只有未付款才能取消)
	
	private String address;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
