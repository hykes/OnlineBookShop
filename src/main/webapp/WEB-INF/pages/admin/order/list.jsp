<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/admin/order/list.htm"/>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="${base}/styles/admin/nav.css" rel="stylesheet" />
</head>
<body>
	<table cellpadding="0" cellspacing="1" class="table neitable columntables">
        <tr id="list-top"> 
            <td class="list">订单ID</td>
            <td class="list">创建时间</td> 
            <td class="list">总价</td>
            <td class="list">用户</td>   
            <td class="list">地址</td>           
            <td class="list">状态</td>           
            <td class="list">操作</td>
        </tr>
 	<span id="25" style="width:50px;">
		<c:forEach var="order" items="${page.list}" varStatus="s">
			<tr class="mouse click column_${s.count}">
				<td class="list-text color999">${order.id}</td>
				<td class="list-text color999">${order.createTime}</td>
				<td class="list-text color999">${order.total}</td>
				<td class="list-text color999">${order.userId}</td>
				<td class="list-text color999">${order.address}</td>
				<td class="list-text color999">
                  	<c:if test="${order.status eq 1}">未付款</c:if>
                  	<c:if test="${order.status eq 2}">已付款但未发货</c:if>                  
                  	<c:if test="${order.status eq 3}">已发货未确认收货</c:if>                  
                  	<c:if test="${order.status eq 4}">交易完成</c:if>
                  	<c:if test="${order.status eq 5}">已取消</c:if>						
				</td>
				<td class="list-text">
					<div class="lista">
					<c:if test="${order.status eq 2 }">
              		<a href="${base}/admin/order/fahuo.htm?id=${order.id}">发货</a>
              		</c:if>
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