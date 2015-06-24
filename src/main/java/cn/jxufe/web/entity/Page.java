package cn.jxufe.web.entity;

import java.util.List;
/**
 * 
* 类名称：Page   
* 类描述： 分页类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月1日 上午9:15:31     
* 修改备注：   
* @version
 */
public class Page {
	private int totalRecord;// 表示查询后一共得到多少条结果记录
	private int pageSize; // 表示页面一次要显示多少条记录
	private int totalPage;// 表示将所有的记录进行分页后，一共有多少页
	private int startIndex;// 表示从所有的结果记录中的哪一个编号开始分页查询
	private int currentPage; // 当前查看页
	
	private int firstPage;
	private int secondPage;

	private List list =null;// list集合是用来装载一个页面中的所有记录的

	
	public Page(int pageNum) {
		this.currentPage = pageNum;
		this.pageSize = 10;// 设置一页默认显示10条查询记录
		this.startIndex = (this.currentPage - 1) * this.pageSize;// 至于为什么this.page要减1，
		// 是因为mysql数据库对于分页查询时，得到的所有的查询记录，第一条记录的编号是从0开始。
	}
	
	public Page(int pageNum, int pageSize) {
		this.currentPage = pageNum;
		this.pageSize = pageSize;// 设置一页默认显示10条查询记录
		this.startIndex = (this.currentPage - 1) * this.pageSize;// 至于为什么this.page要减1，
		// 是因为mysql数据库对于分页查询时，得到的所有的查询记录，第一条记录的编号是从0开始。
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (this.totalRecord % this.pageSize == 0) {
			this.totalPage = this.totalRecord / this.pageSize;
		} else {
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getFirstPage() {
		if(this.currentPage-4>1){
			this.firstPage=this.currentPage-4;
		}else{
			this.firstPage=1;
		}
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getSecondPage() {
		if(this.currentPage+4<=totalPage){
			this.secondPage=this.currentPage+4;
		}else{
			this.secondPage=totalPage;
		}
		return secondPage;
	}

	public void setSecondPage(int secondPage) {
		this.secondPage = secondPage;
	}
}
