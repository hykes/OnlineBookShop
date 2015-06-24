package cn.jxufe.web.home.service;

import java.util.List;

import cn.jxufe.web.entity.CartItem;
import cn.jxufe.web.entity.Page;

public interface CartItemService {

	public abstract int insertCartItem(CartItem item) throws Exception;

	public abstract int updateCartItem(CartItem item) throws Exception;

	public abstract int deleteCartItem(Integer id) throws Exception;

	public abstract CartItem queryCartItem(Integer id);

	public abstract Page getCartItemPage(Page page);

	public abstract List<CartItem> getCartItemList(Integer id);
	
	public abstract long queryCountForCart(Integer userId, Integer bookId);
	
	public abstract int copyCartItemToOrderItem(Integer cartItemId, Integer orderId) throws Exception;

}