package cn.jxufe.web.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.Order;
import cn.jxufe.web.entity.OrderItem;
import cn.jxufe.web.entity.Page;

@Service
public  class OrderServiceImpl implements OrderService {
	
	@Autowired
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#insertOrder(cn.jxufe.web.entity.Order)
	 */
	public int insertOrder(Order order) throws Exception{
		String sql = "insert into t_order(createTime,total,status,address,userId) values(now(),?,?,?,?)";
		Object[] args=new Object[]{ order.getTotal(), order.getStatus(), order.getAddress(), order.getUserId() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#updateOrder(cn.jxufe.web.entity.Order)
	 */
	public int updateOrderStatus(Integer status, Integer id) throws Exception{
		String sql = "update t_order set status=? where id=?";
		Object[] args=new Object[]{ status, id  };
		return baseDao.executeByArray(sql, args);
	}
	public int updateOrderAddress(String address, Integer id) throws Exception{
		String sql = "update t_order set address=? where id=?";
		Object[] args=new Object[]{ address, id  };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#deleteOrder(java.lang.Integer)
	 */
	public int deleteOrder(Integer id) throws Exception{
		String sql = "delete from t_order where id=?";
		Object[] args=new Object[]{ id };
		baseDao.executeByArray(sql, args);
		 sql= "delete from t_orderitem where orderId=?";
		Object[] args2=new Object[]{ id };
		return baseDao.executeByArray(sql, args2);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#queryOrder(java.lang.Integer)
	 */
	public Order queryOrder(Integer id){
		String sql = "select * from t_order where id = ? ";
		Object[] args = new Object[] { id };
		return  (Order) baseDao.findUniqueBeanByArray(sql, Order.class, args);
	}

	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#getOrderPage(cn.jxufe.web.entity.Page)
	 */
	public Page getOrderPage(Page page){
		String sql = "select * from t_order order by createTime desc";
		Object[] args = new Object[] {  };
		return baseDao.findPageListByArray(page, Order.class, sql, args);
	}
	
	
	public Page getOrderPageByUserId(Page page, Integer id){
		String sql = "select * from t_order where userId=? order by createTime desc";
		Object[] args = new Object[] { id };
		return baseDao.findPageListByArray(page, Order.class, sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.OrderService#getOrderList()
	 */
	public List<Order> getOrderItemList(Integer id){
		String sql = "select * from t_orderitem where orderId=?";
		Object[] args = new Object[] { id };
		return baseDao.findListBeanByArray(sql, OrderItem.class, args);
	}
	
	public int getKey(Order order)throws Exception{
		String sql="insert into t_order(createTime,total,status,userId) values(now(),?,?,?)";
		Object[] args=new Object[]{  order.getTotal(), order.getStatus(), order.getUserId() };
		return baseDao.executeGetKey(sql, args);
	}
	
	public int insertOrderItem(OrderItem orderItem) throws Exception{
		String sql = "insert into t_orderitem(quantity,bookId,subtotal,bookName,currPrice,imagePath,orderId) values(?,?,?,?,?,?,?)";
		Object[] args=new Object[]{ orderItem.getQuantity(), orderItem.getBookId(),orderItem.getSubtotal(), orderItem.getBookName(), orderItem.getCurrPrice(), orderItem.getImagePath(), orderItem.getOrderId() };
		return baseDao.executeByArray(sql, args);
	}

}
