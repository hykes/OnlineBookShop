package cn.jxufe.web.entity;

/**
 * 
* 类名称：Order   
* 类描述： 订单详情类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:27:50     
* 修改备注：   
* @version
 */
public class OrderItem {

	private Integer id; //主键

	private Integer quantity;
	
	private Double subtotal;
	
	private Integer bookId;
	
	private String bookName;
	
	private Double currPrice;
	
	private String imagePath;
	
	private Integer orderId;

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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getCurrPrice() {
		return currPrice;
	}

	public void setCurrPrice(Double currPrice) {
		this.currPrice = currPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
