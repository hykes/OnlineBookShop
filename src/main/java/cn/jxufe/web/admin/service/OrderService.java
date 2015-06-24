package cn.jxufe.web.admin.service;

import java.util.List;

import cn.jxufe.web.entity.Order;
import cn.jxufe.web.entity.OrderItem;
import cn.jxufe.web.entity.Page;

public interface OrderService {

	public abstract int insertOrder(Order order) throws Exception;

	public int updateOrderStatus(Integer status, Integer id) throws Exception;
	public int updateOrderAddress(String address, Integer id) throws Exception;

	public abstract int deleteOrder(Integer id) throws Exception;

	public abstract Order queryOrder(Integer id);

	public abstract Page getOrderPage(Page page);
	
	public abstract Page getOrderPageByUserId(Page page, Integer id);

	public abstract List<Order> getOrderItemList(Integer id);
	
	public abstract int getKey(Order order)throws Exception;
	
	public abstract int insertOrderItem(OrderItem orderItem) throws Exception;

}