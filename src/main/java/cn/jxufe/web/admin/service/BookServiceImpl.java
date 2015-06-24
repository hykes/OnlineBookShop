package cn.jxufe.web.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.Book;
import cn.jxufe.web.entity.Page;

@Service
public  class BookServiceImpl implements BookService {
	
	@Resource
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#insertBook(cn.jxufe.web.entity.Book)
	 */
	public int insertBook(Book book) throws Exception{
		String sql = "insert into t_book(name,author,price,currPrice,discount,press,publishTime,edition,pageNum,wordNum,printTime,booksize,paper,categoryId,imagePath,description,orderIndex) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args=new Object[]{ book.getName(), book.getAuthor(), book.getPrice(), book.getCurrPrice(), book.getDiscount(), book.getPress(),
					book.getPublishTime(),book.getEdition(), book.getPageNum(), book.getWordNum(), book.getPrintTime(), book.getBooksize(), book.getPaper(), book.getCategoryId(),
					book.getImagePath(), book.getDescription(), book.getOrderIndex()
		};
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#updateBook(cn.jxufe.web.entity.Book)
	 */
	public int updateBook(Book book) throws Exception{
		String sql = "update t_book set name=?,author=?,price=?,currPrice=?,discount=?,press=?,"
				+ "publishTime=?,edition=?,wordNum=?,printTime=?,booksize=?,categoryId=?,description=?,orderIndex=? where id=?";
		Object[] args=new Object[]{ book.getName(), book.getAuthor(), book.getPrice(), book.getCurrPrice(), book.getDiscount(), book.getPress(),
				book.getPublishTime(),book.getEdition(),book.getWordNum(), book.getPrintTime(), book.getBooksize(), book.getCategoryId(),
				book.getDescription(), book.getOrderIndex(),  book.getId()
		};
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#deleteBook(java.lang.Integer)
	 */
	public int deleteBook(Integer id) throws Exception{
		String sql = "delete from t_book where id=?";
		Object[] args=new Object[]{ id };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#queryBook(java.lang.Integer)
	 */
	public Book queryBook(Integer id){
		String sql = "select * from t_book where id = ? ";
		Object[] args = new Object[] { id };
		return  (Book) baseDao.findUniqueBeanByArray(sql, Book.class, args);
	}

	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#getBookPage(cn.jxufe.web.entity.Page)
	 */
	public Page getBookPage(Page page){
		String sql = "select * from t_book";
		Object[] args = new Object[] {  };
		return baseDao.findPageListByArray(page, Book.class, sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#getBookList()
	 */
	public List<Book> getBookList(){
		String sql = "select * from t_book";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, Book.class, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.BookService#getBookListForIndex()
	 */
	public List<Book> getBookListForIndex(){
		String sql = "select * from t_book order by id desc limit 0,12";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, Book.class, args);
	}
	
	public Page getBookPageForList(Page page, Integer id){
		String sql = "";
		Object[] args ;
		if(id!=0){
			sql = "select * from t_book where categoryId=? or categoryId in(select id from t_category where pid=?)";
			args = new Object[] { id, id };
		}else{
			sql = "select * from t_book";
			args = new Object[] { };
		}
		return baseDao.findPageListByArray(page, Book.class, sql, args);
	}
	
	public Page getBookPage(Page page,String bookName){
		String sql = "select * from t_book where name like ?";
		Object[] args = new Object[] { "%"+bookName+"%" };
		return baseDao.findPageListByArray(page, Book.class, sql, args);
	}
	
	public List<Book> getBookListForDetails(Integer cateId){
		String sql = "select * from t_book where categoryId=? order by id desc limit 0,12";
		Object[] args = new Object[] { cateId };
		return baseDao.findListBeanByArray(sql, Book.class, args);
	}
	
}
