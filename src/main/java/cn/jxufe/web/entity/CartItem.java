package cn.jxufe.web.entity;

/**
 * 
* 类名称：CartItem   
* 类描述： 购物车
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:19:36     
* 修改备注：   
* @version
 */
public class CartItem {

	private Integer id; //主键
	
	private Integer quantity;
	
	private Integer bookId;
	
	private Integer userId;
	
	private Integer orderIndex;
	
	private double currPrice;
	private double total;
	private String bookName;
	private String imagePath;

	public double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(double currPrice) {
		this.currPrice = currPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	
}
