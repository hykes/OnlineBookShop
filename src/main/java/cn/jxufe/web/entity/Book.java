package cn.jxufe.web.entity;

import java.util.Date;

/**
 * 
* 类名称：Book   
* 类描述： 图书类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:39:56     
* 修改备注：   
* @version
 */
public class Book {

	private Integer id; //主键

	private String name;
	private String author;
	private Double price;
	private Double currPrice;
	private Double discount;
	private String press;
	private Date publishTime;
	private Integer edition;
	private Integer pageNum;
	private Integer wordNum;
	private Date printTime;
	private Integer booksize;
	private String paper;
	private Integer categoryId;
	private String imagePath;
	private String description;
	private Integer orderIndex;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getCurrPrice() {
		return currPrice;
	}
	public void setCurrPrice(Double currPrice) {
		this.currPrice = currPrice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getWordNum() {
		return wordNum;
	}
	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}

	public Date getPrintTime() {
		return printTime;
	}
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}
	public Integer getBooksize() {
		return booksize;
	}
	public void setBooksize(Integer booksize) {
		this.booksize = booksize;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

}
