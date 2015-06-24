package cn.jxufe.web.admin.service;

import java.util.List;

import cn.jxufe.web.entity.Book;
import cn.jxufe.web.entity.Page;

public interface BookService {

	public abstract int insertBook(Book book) throws Exception;

	public abstract int updateBook(Book book) throws Exception;

	public abstract int deleteBook(Integer id) throws Exception;

	public abstract Book queryBook(Integer id);

	public abstract Page getBookPage(Page page);

	public abstract List<Book> getBookList();
	
	public abstract List<Book> getBookListForIndex();
	
	public abstract Page getBookPageForList(Page page, Integer id);
	
	public abstract Page getBookPage(Page page,String bookName);
	
	public abstract List<Book> getBookListForDetails(Integer cateId);

}