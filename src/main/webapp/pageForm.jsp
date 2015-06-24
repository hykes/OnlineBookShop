<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
   	页次：${page.currentPage}/${page.totalPage}&nbsp;每页${page.pageSize}&nbsp;总数${page.totalRecord}&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="${pagePath}?p=1">首页</a>
    <c:choose>  
   		<c:when test="${page.currentPage>1}">
   			<a href="${pagePath}?p=${page.currentPage-1}">上一页</a>
   		</c:when>  
   		<c:otherwise>
   				<a href="#">上一页</a>
   		</c:otherwise>  
	</c:choose>
    <c:choose>  
   		<c:when test="${page.currentPage<page.totalPage}">
   			<a href="${pagePath}?p=${page.currentPage+1}">下一页</a>
   		</c:when>  
   		<c:otherwise>
   			<a href="#">下一页</a>
   		</c:otherwise>  
	</c:choose>