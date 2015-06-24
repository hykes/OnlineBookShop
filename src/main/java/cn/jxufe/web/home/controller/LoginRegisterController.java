package cn.jxufe.web.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxufe.core.util.CipherUtil;
import cn.jxufe.web.entity.User;
import cn.jxufe.web.home.service.LoginRegisterService;


@Controller
@RequestMapping
public class LoginRegisterController{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginRegisterService loginService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "/home/login";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		return "/home/register";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request){
		
		String username = request.getParameter("username") == null ? ""
				: (String) request.getParameter("username");
		String password = request.getParameter("password") == null ? ""
				: (String) request.getParameter("password");
		String kaptcha=request.getParameter("kaptcha") == null ? ""
				: (String) request.getParameter("kaptcha");
		String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kaptcha.equals(kaptchaExpected)){
			CipherUtil cipher = new CipherUtil();  
		    String pwd2 = cipher.generatePassword(password); 
			int flag=loginService.loginCheck(username, pwd2);
			if(flag==1){
				User user=loginService.queryUserInfo(username);
				request.getSession().setAttribute("username", username);// 用户名
				request.getSession().setAttribute("id", user.getId());// id
				request.getSession().setAttribute("cnname", user.getCnname());// 中文名
				request.getSession().setMaxInactiveInterval(30*60*60);//会话过期时间
				return "redirect:/index.htm"; 
			}
			else{
				return "redirect:/login.htm?meg="+flag; 
			}
		}
		return "redirect:/login.htm?meg=0"; 
	}
	
	@RequestMapping("/registerCheck")
	public String registerCheck(HttpServletRequest request){
		String username = request.getParameter("username") == null ? ""
				: (String) request.getParameter("username");
		String password = request.getParameter("password") == null ? ""
				: (String) request.getParameter("password");
		String cnname = request.getParameter("cnname") == null ? ""
				: (String) request.getParameter("cnname");
		int count=0;
		try {
			CipherUtil cipher = new CipherUtil();  
		    String pwd2 = cipher.generatePassword(password); 
			count=loginService.register(username, pwd2, cnname);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(count==1){
			return "redirect:/login.htm?meg=200";
		}else{
			return "redirect:/register.htm?meg=202";
		}
		
	}
	
}
