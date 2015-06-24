<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>	
	<link href="${base}/styles/admin/metinfo.css" rel="stylesheet" />
</head>
<body>
<div class="stat_list">
	<ul>
		<li class="now"><a href="#" title="编辑分类">编辑分类</a></li>
	</ul>
</div>
<form method="POST" name="myform" action="${base}/admin/category/saveUpdate.htm" target="_self">
<table cellpadding="2" cellspacing="1" class="table">
	<input type="hidden" name="id" value="${category.id}">
    <tr> 
        <td class="text"><span class="bi_tian">*</span>分类名称：</td>
        <td class="input"><input name="name" type="text" class="text" value="${category.name}" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>分类描述：</td>
        <td class="input"><input name="description" type="text" class="text" value="${category.description}" /></td>
    </tr>
	<tr> 
        <td class="text"><span class="bi_tian">*</span>上级目录：</td>
        <td class="input">
		  <select  name="pid">
			<option value="0" ${category.id eq 0 ? 'selected="selected"' : ''}>无</option>
  			<c:forEach var="cate" items="${categoryList}" varStatus="s">
				<option value="${cate.id}" ${category.pid eq cate.id ? 'selected="selected"' : ''}>${cate.name}</option>
			</c:forEach>
		</select>
		</td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>排序索引：</td>
        <td class="input"><input name="orderIndex" type="text" class="text" value="${category.orderIndex}" /></td>
    </tr>
	<tr> 
        <td class="text"></td>
	    <td class="submit">
		<input type="submit" name="submit" value="确认修改" class="submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>