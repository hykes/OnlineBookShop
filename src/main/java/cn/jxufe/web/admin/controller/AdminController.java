package cn.jxufe.web.admin.controller;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.jxufe.core.common.Constant;
import cn.jxufe.core.util.CipherUtil;
import cn.jxufe.core.util.PropertiesUtil;
import cn.jxufe.web.admin.service.BookService;
import cn.jxufe.web.admin.service.CategoryService;
import cn.jxufe.web.admin.service.OrderService;
import cn.jxufe.web.admin.service.SystemService;
import cn.jxufe.web.admin.service.UserService;
import cn.jxufe.web.entity.Book;
import cn.jxufe.web.entity.Category;
import cn.jxufe.web.entity.Page;


@Controller
@RequestMapping("/admin")
public class AdminController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	public CategoryService categoryService;
	@Resource
	public UserService userService;
	@Resource
	public BookService bookService;
	@Resource
	public OrderService orderService;
	@Resource	
	public SystemService systemService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		return "admin/index";
	}
	
	@RequestMapping("/system/home")
	public String systemHome(HttpServletRequest request){
		request.setAttribute("bookCount", systemService.getBookCount());
		request.setAttribute("userCount", systemService.getUserCount());
		request.setAttribute("orderCount", systemService.getOrderCount());
		return "admin/system/home";
	}
	
	@RequestMapping("/system/updatePwd")
	public String systemUpdatePwd(HttpServletRequest request){
		return "admin/system/updatePwd";
	}
	
	@RequestMapping("/system/saveUpdatePwd")
	public String systemSaveUpdatePwd(HttpServletRequest request){
		String password=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		Integer id=(Integer) request.getSession().getAttribute("id");
		int cnt=0;
		try {
			CipherUtil cipher = new CipherUtil();  
		    String pwd = cipher.generatePassword(newpassword); 
		    String pwd2 = cipher.generatePassword(password); 
			cnt=userService.updateAdminPwd(id, pwd, pwd2);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/system/updatePwd.htm?id="+cnt; 
	}
	
	@RequestMapping("/category/list")
	public String categoryList(HttpServletRequest request){
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum));
		request.setAttribute("page", categoryService.getCategoryPage(page));
		request.setAttribute("categoryList", categoryService.getCategoryList());
		return "admin/category/list";
	}
	
	@RequestMapping("/category/add")
	public String categoryAdd(HttpServletRequest request){
		request.setAttribute("categoryList", categoryService.getPCategoryList());
		return "admin/category/add";
	}
	
	@RequestMapping("/category/saveAdd")
	public String categorySaveAdd(HttpServletRequest request, Category cate){
		try {
			categoryService.insertCategory(cate);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/category/list.htm"; 
	}
	
	@RequestMapping("/category/del")
	public String categoryDel(HttpServletRequest request){
		return "admin/category/add";
	}
	
	@RequestMapping("/category/update")
	public String categoryUpdate(HttpServletRequest request){
		String id=request.getParameter("id");
		request.setAttribute("category", categoryService.queryCategory(Integer.valueOf(id)));
		request.setAttribute("categoryList", categoryService.getPCategoryList());
		return "admin/category/update";
	}
	
	@RequestMapping("/category/saveUpdate")
	public String categorySaveUpdate(HttpServletRequest request,Category cate){
		try {
			categoryService.updateCategory(cate);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/category/list.htm"; 
	}
	
	@RequestMapping("/book/list")
	public String bookList(HttpServletRequest request){
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum));
		request.setAttribute("page", bookService.getBookPage(page));
		return "admin/book/list";
	}
	
	@RequestMapping("/book/add")
	public String bookAdd(HttpServletRequest request){
		request.setAttribute("categoryList", categoryService.getCategoryList());
		return "admin/book/add";
	}
	
	@RequestMapping("/book/saveAdd")
	public String bookSaveAdd(MultipartHttpServletRequest request, Book book){

		try {
			//读取配置文件
			PropertiesUtil pUtil = PropertiesUtil
					.createPropertiesUtil(Constant.UPLOADPATH_FILE);
			List<MultipartFile> files = request.getFiles("myFile");
			// 通过配置文件得到上传路径
			String uploadpath = request.getSession().getServletContext()
					.getRealPath(pUtil.getProperty(Constant.UPLOADPATH_PATH));
			int no = 1;
			String newFileName=null;
			for (MultipartFile file : files) {
				if (file.isEmpty())
					continue;
				String oldName=file.getOriginalFilename();
				String suffixName=oldName.substring(oldName.lastIndexOf(".")+1);
				// 一般来说需要对文件进行改名,下面的为时间+序号
				String realName=(new Date()).getTime()+"_"+no+"."+suffixName;
				FileOutputStream fileOS = new FileOutputStream(uploadpath +
				 "/"+ realName);
				fileOS.write(file.getBytes());
				fileOS.close();
				no = no + 1;
				newFileName="/upload/"+ realName;
			}
			book.setImagePath(newFileName);
			book.setCurrPrice(book.getPrice()*book.getDiscount());
			bookService.insertBook(book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		}
		
		return "redirect:/admin/book/list.htm"; 
	}
	
	@RequestMapping("/book/update")
	public String bookUpdate(HttpServletRequest request){
		String id=request.getParameter("id");
		request.setAttribute("categoryList", categoryService.getCategoryList());
		request.setAttribute("book",bookService.queryBook(Integer.valueOf(id)));
		return "admin/book/update";
	}
	
	
	@RequestMapping("/book/del")
	public String bookDel(HttpServletRequest request){
		String id=request.getParameter("id");
		try {
			System.out.println(id+"------------");
			request.setAttribute("book",bookService.deleteBook(Integer.valueOf(id)));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/book/list.htm"; 
	}
	
	@RequestMapping("/book/saveUpdate")
	public String bookSaveUpdate(HttpServletRequest request,Book book){
		try {
			book.setCurrPrice(book.getPrice()*book.getDiscount());
			bookService.updateBook(book);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/book/list.htm"; 
	}
	
	
	@RequestMapping("/order/list")
	public String orderList(HttpServletRequest request){
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum));
		request.setAttribute("page", orderService.getOrderPage(page));
		return "admin/order/list";
	}
	@RequestMapping("/order/fahuo")
	public String orderFahuo(HttpServletRequest request){
		String id=request.getParameter("id");
		try {
			orderService.updateOrderStatus(3, Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/order/list.htm"; 
	}
	
	@RequestMapping("/user/list")
	public String userList(HttpServletRequest request){
		String pageNum=request.getParameter("p")==null?"1":request.getParameter("p");
		Page page=new Page(Integer.valueOf(pageNum));
		request.setAttribute("page", userService.getUserPage(page));
		return "admin/user/list";
	}
	
	@RequestMapping("/user/del")
	public String userDel(HttpServletRequest request, Book book){
		String id=request.getParameter("id");
		try {
			userService.deleteUser(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "redirect:/admin/user/list.htm"; 
	}
	
	
}