<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/admin/user/list.htm"/>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="${base}/styles/admin/nav.css" rel="stylesheet" />
</head>
<body>
	<table cellpadding="0" cellspacing="1" class="table neitable columntables">
        <tr id="list-top"> 
            <td class="list">用户ID</td>
            <td class="list">用户名称</td> 
            <td class="list">中文名称</td>
            <td class="list">注册时间</td>   
            <td class="list">邮箱</td>           
            <td class="list">地址</td>           
            <td class="list">电话</td>           
            <td class="list">操作</td>
        </tr>
 	<span id="25" style="width:50px;">
		<c:forEach var="user" items="${page.list}" varStatus="s">
			<tr class="mouse click column_${s.count}">
				<td class="list-text color999">${user.id}</td>
				<td class="list-text color999">${user.username}</td>
				<td class="list-text color999">${user.cnname}</td>
				<td class="list-text color999">${user.createTime}</td>
				<td class="list-text color999">${user.email}</td>
				<td class="list-text color999">${user.address}</td>
				<td class="list-text color999">${user.phone}</td>
				<td class="list-text">
					<div class="lista">
					<%-- <a href="<c:url value='/admin/user/update.htm?id=${user.id}' />">编辑</a> --%>
              		<a href="${base}/admin/user/del.htm?id=${user.id}" >删除</a>
					</div>
				</td>
			</tr>
		</c:forEach>	
   	<tr align="center" bgcolor="#F9FCEF" height="28"> 
      <td colspan="8">
		<%@ include file="/pageForm.jsp"%>
      </td>
     </tr>
    </span>
    </table>   
<script type="text/javascript" src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>
</body>
</html>