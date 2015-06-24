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
		<li class="now"><a href="${base}/admin/category/add.htm" title="添加分类">添加分类</a></li>
	</ul>
</div>
<form method="POST" name="myform" action="${base}/admin/category/saveAdd.htm" target="_self">
<table cellpadding="2" cellspacing="1" class="table">
    <tr> 
        <td class="text"><span class="bi_tian">*</span>分类名称：</td>
        <td class="input"><input name="name" type="text" class="text" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>分类描述：</td>
        <td class="input"><input name="description" type="text" class="text" /></td>
    </tr>
	<tr> 
        <td class="text"><span class="bi_tian">*</span>上级目录：</td>
        <td class="input">
		  <select name="pid">
			<option value="0">无</option>
  			<c:forEach var="category" items="${categoryList}" varStatus="s">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
		</td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>排序索引：</td>
        <td class="input"><input name="orderIndex" type="text" class="text" value="1"/></td>
    </tr>
	<tr> 
        <td class="text"></td>
	    <td class="submit">
		<input type="submit" name="submit" value="确认添加" class="submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>