<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  	session.invalidate(); 
  	String path = request.getContextPath();
	response.sendRedirect(path+"/index.htm");  
%>   
