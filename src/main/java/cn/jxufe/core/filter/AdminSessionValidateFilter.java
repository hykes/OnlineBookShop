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

/**
 * 
* 类名称：AdminSessionValidateFilter   
* 类描述： 后台监听器
* 创建人：Jxufe HeHaiYang
* 创建时间：2015年6月4日 下午12:30:49     
* 修改备注：   
* @version
 */
public class AdminSessionValidateFilter implements Filter {
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		//未登录返回登录页面
		if (session == null || session.getAttribute("type") !="admin") {
			String PATH=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			response.sendRedirect(PATH+"adminlogin.htm");
		}else{
			chain.doFilter(request, response);	
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {}

}