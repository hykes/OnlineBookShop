<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
   <!--S top-->
   <div class="top navbar-fixed-top">
      <div class="t_header">
	     <div class="t_nav">
		    <a href="${base}/index.htm">嗨，欢迎您访问在线书店！</a>
		 </div>
		 <div class="t_inf">
		 	<% String name=(String)session.getAttribute("username"); 
   			if(name!=null){%>
				<a href="${base}/home/user/info.htm">个人中心</a><span>|</span><a href="${base}/home/order/list.htm">我的订单</a><span>|</span><a href="${base}/home/cart/list.htm">我的购物车</a><span>|</span><a href="${base}/loginOut.jsp">退出</a>
			<%}else{ %>
 				 <a href="${base}/login.htm">登录</a><span>|</span><a href="${base}/register.htm">注册</a>
			<%}%>
		  
		 </div>
	  </div>
   </div>
   <!--E top-->