<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/admin/book/list.htm"/>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="${base}/styles/admin/nav.css" rel="stylesheet" />
</head>
<body>
	<table cellpadding="0" cellspacing="1" class="table neitable columntables">
        <tr id="list-top"> 
            <td class="list">图书ID</td>
            <td class="list">图书名称</td> 
            <td class="list">作者</td>
            <td class="list">出版社</td>   
            <td class="list">排序</td>
            <td class="list">操作</td>
        </tr>
 	<span id="25" style="width:50px;">
		<c:forEach var="book" items="${page.list}" varStatus="s">
			<tr class="mouse click column_${s.count}">
				<td class="list-text color999">${book.id}</td>
				<td class="list-text color999">${fn:substring(book.name, 0, 15)}</td>
				<td class="list-text color999">${book.author}</td>
				<td class="list-text color999">${book.press}</td>
				<td class="list-text color999">${book.orderIndex}</td>
				<td class="list-text">
					<div class="lista">
					<a href="${base}/details.htm?id=${book.id}" target="_blank">详情</a>
					<a href="${base}/admin/book/update.htm?id=${book.id}">编辑</a>
              		<a href="${base}/admin/book/del.htm?id=${book.id}" >删除</a>
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