package cn.jxufe.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jxufe.core.util.GetHttpServletRequestWrapper;

/**
 * 
* 类名称：HomeSessionValidateFilter   
* 类描述： 前台监听器
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月4日 下午12:35:28     
* 修改备注：   
* @version
 */
public class HomeSessionValidateFilter implements Filter {
	
	private String charset = "UTF-8";
	
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		//设置请求响应字符编码  
        request.setCharacterEncoding(charset);  
        response.setCharacterEncoding(charset);  
        
        if(request.getMethod().equalsIgnoreCase("get"))  
        {  
        	request = new GetHttpServletRequestWrapper(request,charset);  
        } 
        
		HttpSession session = request.getSession();
		//未登录返回登录页面
		if ((session == null) || (session.getAttribute("username") == null)) {
			String PATH=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			response.sendRedirect(PATH+"login.htm");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {}

}