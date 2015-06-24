package cn.jxufe.web.home.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.web.admin.service.BookService;
import cn.jxufe.web.admin.service.OrderService;
import cn.jxufe.web.admin.service.UserService;
import cn.jxufe.web.entity.Book;
import cn.jxufe.web.entity.CartItem;
import cn.jxufe.web.entity.Order;
import cn.jxufe.web.entity.OrderItem;
import cn.jxufe.web.entity.Page;
import cn.jxufe.web.entity.User;
import cn.jxufe.web.home.service.CartItemService;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	public CartItemService cartItemService;
	@Resource
	public OrderService orderService;
	@Resource
	public UserService userService;
	@Resource
	public BookService bookService;

	@RequestMapping("/cart/list")
	public String cartList(HttpServletRequest request){
		Integer userId =  (Integer) request.getSession().getAttribute("id");
		request.setAttribute("cartItemList", cartItemService.getCartItemList(userId));
		return "home/cart/list";
	}
	
	@RequestMapping("/cart/updateQuantity")
	@ResponseBody
	public Map cartUpdateQuantity(HttpServletRequest request){
		String id=request.getParameter("id");
		String quantity=request.getParameter("quantity");
		CartItem item=new CartItem();
		item.setId(Integer.valueOf(id));
		item.setQuantity(Integer.valueOf(quantity));
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			cartItemService.updateCartItem(item);
			item=cartItemService.queryCartItem(Integer.valueOf(id));
			map.put("quantity", item.getQuantity());
			map.put("subtotal", item.getTotal());
			return map;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
		
	}
	
	@RequestMapping("/cart/del")
	public String cartDel(HttpServletRequest request){
		String id =request.getParameter("id");
		try {
			cartItemService.deleteCartItem(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/cart/list.htm"; 
	}
	
	@RequestMapping("/cart/oneClickBuy")
	public String cartOneClicBuy(HttpServletRequest request){
		Integer userId=(Integer) request.getSession().getAttribute("id");
		String bookId=request.getParameter("id");
		String quantity=request.getParameter("quantity")==null?"1":request.getParameter("quantity");
		Book book=bookService.queryBook(Integer.valueOf(bookId));
		Order order=new Order();
		order.setStatus(1);
		order.setUserId(userId);
		order.setTotal(book.getCurrPrice()*Integer.valueOf(quantity));
		int key = 0;
		try {
			key=orderService.getKey(order);
			OrderItem orderItem=new OrderItem();
			orderItem.setQuantity(Integer.valueOf(quantity));
			orderItem.setBookName(book.getName());
			orderItem.setCurrPrice(book.getCurrPrice());
			orderItem.setOrderId(key);
			orderItem.setBookId(book.getId());
			orderItem.setSubtotal(book.getCurrPrice()*Integer.valueOf(quantity));
			orderItem.setImagePath(book.getImagePath());
			orderService.insertOrderItem(orderItem);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/order/details.htm?id="+key; 
	}
	
	
	@RequestMapping("/cart/addCart")
	@ResponseBody
	public Map<String, Object> cartAddCart(HttpServletRequest request){
		String bookId=request.getParameter("bookId");
		String quantity=request.getParameter("quantity")==null?"1":request.getParameter("quantity");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if ((session == null) || (session.getAttribute("username") == null)) {
			return map;
		} else {
			Integer userId=(Integer) request.getSession().getAttribute("id");
			long count = cartItemService.queryCountForCart(userId,
					Integer.valueOf(bookId));
			if (count > 0) {
				map.put("msg", 0);
				return map;
			} else {
				CartItem item = new CartItem();
				item.setUserId(userId);
				item.setQuantity(Integer.valueOf(quantity));
				item.setBookId(Integer.valueOf(bookId));
				Book book=bookService.queryBook(Integer.valueOf(bookId));
				item.setBookName(book.getName());
				item.setCurrPrice(book.getCurrPrice());
				item.setImagePath(book.getImagePath());
				item.setTotal(item.getQuantity()*item.getCurrPrice());
				item.setOrderIndex(1);
				try {
					count = cartItemService.insertCartItem(item);
					map.put("msg", 1);
				} catch (Exception e) {
					map.put("msg", -1);
					logger.error(e.getMessage());
				}
				return map;
			}
		}
	}
	
	@RequestMapping("/cart/xiadan")
	public String cartXiadan(HttpServletRequest request){
		int key=0;
		try {
		String cartItemIds = request.getParameter("cartItemIds");
		String total = request.getParameter("total");
		Integer userId=(Integer) request.getSession().getAttribute("id");
		Order order=new Order();
		order.setStatus(1);
		order.setUserId(userId);
		order.setTotal(Double.valueOf(total));
		key=orderService.getKey(order);
		String[] strarray = cartItemIds.split(",");
		for (int i = 0; i < strarray.length; i++)
		{
			cartItemService.copyCartItemToOrderItem(Integer.valueOf(strarray[i]), key);
			cartItemService.deleteCartItem(Integer.valueOf(strarray[i]));
		}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/order/details.htm?id="+key; 
	}
	
	
	@RequestMapping("/order/list")
	public String orderList(HttpServletRequest request){
		Integer userId =  (Integer) request.getSession().getAttribute("id");
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum));
		request.setAttribute("page", orderService.getOrderPageByUserId(page, userId));
		return "home/order/list";
	}
	
	@RequestMapping("/order/details")
	public String orderDetails(HttpServletRequest request){
		String id=request.getParameter("id");
		request.setAttribute("order", orderService.queryOrder(Integer.valueOf(id)));
		request.setAttribute("orderItemList", orderService.getOrderItemList(Integer.valueOf(id)));
		return "home/order/details";
	}
	
	@RequestMapping("/order/pay")
	public String orderPay(HttpServletRequest request){
		String id=request.getParameter("orderId");
		String address = request.getParameter("address");
		try {
			orderService.updateOrderStatus(2, Integer.valueOf(id));
			orderService.updateOrderAddress(address, Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/order/details.htm?id="+id; 
	}
	@RequestMapping("/order/shouhuo")
	public String orderShouhuo(HttpServletRequest request){
		String id=request.getParameter("id");
		try {
			orderService.updateOrderStatus(4, Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/order/details.htm?id="+id; 
	}
	
	
	
	@RequestMapping("/order/del")
	public String orderDel(HttpServletRequest request){
		String id=request.getParameter("id");
		try {
			orderService.deleteOrder(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/order/list.htm"; 
	}
	
	@RequestMapping("/user/info")
	public String userInfo(HttpServletRequest request){
		Integer userId =  (Integer) request.getSession().getAttribute("id");
		User user=userService.queryUser(userId);
		request.setAttribute("user", user);
		return "home/user/info";
	}
	
	@RequestMapping("/user/saveInfo")
	public String saveUserInfo(HttpServletRequest request,User user){
		try {
			System.out.println(user.getPhone());
			userService.updateUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/user/info.htm"; 
	}
	
	
	
	@RequestMapping("/user/updatePwd")
	public String updatePwd(HttpServletRequest request){
		return "home/user/updatePwd";
	}
	
	@RequestMapping("/user/saveUpdatePwd")
	public String saveUpdatePwd(HttpServletRequest request){
		Integer userId =  (Integer) request.getSession().getAttribute("id");
		String newpassword=request.getParameter("newpassword");
		try {
			userService.updateUserPwd(userId, newpassword);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/home/user/info.htm"; 
	}
	
}