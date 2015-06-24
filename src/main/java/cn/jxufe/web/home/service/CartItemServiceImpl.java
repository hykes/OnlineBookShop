package cn.jxufe.web.home.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.CartItem;
import cn.jxufe.web.entity.Page;

@Service
public  class CartItemServiceImpl implements CartItemService  {
	
	@Resource
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#insertCartItem(cn.jxufe.web.entity.CartItem)
	 */
	public int insertCartItem(CartItem item) throws Exception{
		String sql = "insert into t_cartItem(quantity,bookId,userId,orderIndex,currPrice,total,bookName,imagePath) values(?,?,?,?,?,?,?,?)";
		Object[] args=new Object[]{ item.getQuantity(), item.getBookId(), item.getUserId(), item.getOrderIndex(), item.getCurrPrice(), item.getTotal(),
					item.getBookName(), item.getImagePath()
		};
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#updateCartItem(cn.jxufe.web.entity.CartItem)
	 */
	public int updateCartItem(CartItem item) throws Exception{
		String sql = "update t_cartItem set quantity=? ,total=?*currPrice where id=?";
		Object[] args=new Object[]{ item.getQuantity(), item.getQuantity(), item.getId() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#deleteCartItem(java.lang.Integer)
	 */
	public int deleteCartItem(Integer id) throws Exception{
		String sql = "delete from t_cartitem where id=?";
		Object[] args=new Object[]{ id };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#queryCartItem(java.lang.Integer)
	 */
	public CartItem queryCartItem(Integer id){
		String sql = "select * from t_cartItem where id = ? ";
		Object[] args = new Object[] { id };
		return  (CartItem) baseDao.findUniqueBeanByArray(sql, CartItem.class, args);
	}

	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#getCartItemPage(cn.jxufe.web.entity.Page)
	 */
	public Page getCartItemPage(Page page){
		String sql = "select * from t_cartItem";
		Object[] args = new Object[] {  };
		return baseDao.findPageListByArray(page, CartItem.class, sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.home.service.CartItemService#getCartItemList()
	 */
	public List<CartItem> getCartItemList(Integer id){
		String sql = "select * from t_cartitem where userId=?";
		Object[] args = new Object[] { id };
		return baseDao.findListBeanByArray(sql, CartItem.class, args);
	}
	
	public long queryCountForCart(Integer userId, Integer bookId){
		String sql="select count(*) from t_cartItem where userId=? and bookId=?";
		Object[] args = new Object[] { userId, bookId };
		return baseDao.findLongByArray(sql, args);
	}
	
	public int copyCartItemToOrderItem(Integer cartItemId, Integer orderId) throws Exception{
		String sql = "insert into t_orderitem(quantity,subtotal,bookId,bookName,currPrice,"
				+ "imagePath,orderId) select quantity,"
				+ "total,bookId,bookName,currPrice,imagePath,? as orderId from t_cartitem where id=?";
		Object[] args = new Object[] { orderId, cartItemId };
		return baseDao.executeByArray(sql, args);
	}
	
	
}
