package cn.jxufe.web.entity;

/**
 * 
* 类名称：Category   
* 类描述： 图书分类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:15:06     
* 修改备注：   
* @version
 */
public class Category {

	private Integer id; //主键
	
	private String name;
	
	private Integer pid;
	
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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
