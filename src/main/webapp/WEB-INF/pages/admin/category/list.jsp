<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/admin/category/list.htm"/>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="${base}/styles/admin/nav.css" rel="stylesheet" />
</head>
<body>
	<table cellpadding="0" cellspacing="1" class="table neitable columntables">
        <tr id="list-top"> 
            <td class="list">分类ID</td>
            <td class="list">分类名称</td> 
            <td class="list">上级分类</td>
            <td class="list">分类描述</td>   
            <td class="list">排序</td>           
            <td class="list">操作</td>
        </tr>
 	<span id="25" style="width:50px;">
		<c:forEach var="category" items="${page.list}" varStatus="s">
			<tr class="mouse click column_${s.count}">
				<td class="list-text color999">${category.id}</td>
				<td class="list-text color999">${category.name}</td>
				<td class="list-text color999">
				<c:if test="${category.pid eq 0}">
					一级目录
				</c:if>
				<c:forEach var="cate" items="${categoryList}" varStatus="m">	
					<c:if test="${category.pid eq cate.id}">
						${cate.name}
					</c:if>
				</c:forEach>
				</td>
				<td class="list-text color999">${category.description}</td>
				<td class="list-text color999">${category.orderIndex}</td>
				<td class="list-text">
					<div class="lista">
					<a href="${base}/admin/category/update.htm?id=${category.id}">编辑</a>
              		<!-- <a href="${base}/admin/category/del.htm?id=${category.id}" >删除</a> -->
					</div>
				</td>
			</tr>
		</c:forEach>	
   	<tr align="center" bgcolor="#F9FCEF" height="28"> 
      <td colspan="7">
		<%@ include file="/pageForm.jsp"%>
      </td>
     </tr>
    </span>
    </table>
<script type="text/javascript" src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>
</body>
</html>