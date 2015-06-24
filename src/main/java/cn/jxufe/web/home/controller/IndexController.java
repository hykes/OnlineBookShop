package cn.jxufe.web.home.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxufe.web.admin.service.BookService;
import cn.jxufe.web.admin.service.CategoryService;
import cn.jxufe.web.entity.Book;
import cn.jxufe.web.entity.Page;


@Controller
@RequestMapping
public class IndexController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	public BookService bookService;
	@Resource
	public CategoryService categoryService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		request.setAttribute("bookList", bookService.getBookListForIndex());
		request.setAttribute("categoryList", categoryService.getPCategoryListForIndex());
		return "home/index";
	}
	
	@RequestMapping("/details")
	public String details(HttpServletRequest request){
		String id=request.getParameter("id");
		Book book=bookService.queryBook(Integer.valueOf(id));
		request.setAttribute("book", book);
		request.setAttribute("categoryBook", bookService.getBookListForDetails(book.getCategoryId()));
		return "home/details";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		String id=request.getParameter("id")==null?"0":request.getParameter("id");
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum),12);
		request.setAttribute("page", bookService.getBookPageForList(page, Integer.valueOf(id)));
		request.setAttribute("categoryList", categoryService.getCategoryList());
		request.setAttribute("categoryId", id);
		return "home/list";
	}
	
	@RequestMapping("/category")
	public String category(HttpServletRequest request){
		request.setAttribute("categoryList", categoryService.getCategoryList());
		return "home/category";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request){
		String bookName=request.getParameter("bookName");
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum),12);
		page=bookService.getBookPage(page, bookName);
		request.setAttribute("page", page);
		request.setAttribute("count", page.getTotalRecord());
		request.setAttribute("bookName", bookName);
		return "home/search";
	}
	
}