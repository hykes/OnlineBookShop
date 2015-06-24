package cn.jxufe.web.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxufe.core.util.CipherUtil;
import cn.jxufe.web.admin.service.SystemService;
import cn.jxufe.web.entity.Admin;


@Controller
@RequestMapping
public class AdminLoginController {

	@Resource	
	public SystemService systemService;
	
	@RequestMapping("/adminlogin")
	public String index(HttpServletRequest request){
		return "admin/login";
	}
	
	@RequestMapping("/adminCheck")
	public String adminCheck(HttpServletRequest request){
		String username = request.getParameter("username") == null ? ""
				: (String) request.getParameter("username");
		String password = request.getParameter("password") == null ? ""
				: (String) request.getParameter("password");
			CipherUtil cipher = new CipherUtil();  
		    String pwd2 = cipher.generatePassword(password); 
			int flag=systemService.loginCheck(username, pwd2);
			if(flag==1){
				Admin admin=systemService.queryAdminInfo(username);
				request.getSession().setAttribute("username", username);// 用户名
				request.getSession().setAttribute("id", admin.getId());// id
				request.getSession().setAttribute("cnname", admin.getCnname());// 中文名
				request.getSession().setAttribute("type", "admin");// 中文名
				request.getSession().setMaxInactiveInterval(30*60*60);//会话过期时间
				return "redirect:/admin/index.htm"; 
			}else{
				return "redirect:/adminlogin.htm"; 
			}
	}
	
	
}