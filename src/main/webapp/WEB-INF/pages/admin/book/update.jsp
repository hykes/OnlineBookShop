<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>	
	<link href="${base}/styles/admin/metinfo.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${base}/plugin/umeditor/themes/default/css/umeditor.css" />
	<script type="text/javascript" src="${base}/plugin/umeditor/third-party/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${base}/plugin/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/plugin/umeditor/umeditor.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${base}/plugin/umeditor/lang/zh-cn/zh-cn.js"></script>	
</head>
<body>
<div class="stat_list">
	<ul>
		<li class="now"><a href="#" title="编辑图书">编辑图书</a></li>
	</ul>
</div>
<form method="POST" name="myform" action="${base}/admin/book/saveUpdate.htm" target="_self">
	<input type="hidden" value="${book.id}" name="id">
  <table cellpadding="2" cellspacing="1" class="table">
    <tr> 
        <td class="text"><span class="bi_tian">*</span>图书名称：</td>
        <td class="input"><input name="name" type="text" class="text" value="${book.name}"/></td>       
        <td class="text"><span class="bi_tian">*</span>作者：</td>
        <td class="input"><input name="author" type="text" class="text"  value="${book.author}"/></td>
    </tr>
    <tr>         
        <td class="text"><span class="bi_tian">*</span>价格：</td>
        <td class="input"><input name="price" type="text" class="text"  value="${book.price}"/></td>
        <td class="text"><span class="bi_tian">*</span>折扣：</td>
        <td class="input">
        <select name="discount">
        	<option value="1" ${book.discount eq 1 ? 'selected="selected"' : ''}>无折扣</option>
        	<option value="0.95" ${book.discount eq 0.95 ? 'selected="selected"' : ''}>95折</option>
        	<option value="0.9" ${book.discount eq 0.9 ? 'selected="selected"' : ''}>9折</option>
        	<option value="0.85" ${book.discount eq 0.85 ? 'selected="selected"' : ''}>85折</option>
        	<option value="0.8" ${book.discount eq 0.8 ? 'selected="selected"' : ''}>8折</option>
        	<option value="0.75" ${book.discount eq 0.75 ? 'selected="selected"' : ''}>75折</option>
        	<option value="0.7" ${book.discount eq 0.7 ? 'selected="selected"' : ''}>7折</option>
        	<option value="0.65" ${book.discount eq 0.65 ? 'selected="selected"' : ''}>65折</option>
        	<option value="0.6" ${book.discount eq 0.6 ? 'selected="selected"' : ''}>6折</option>
        </select>        
        </td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>出版社：</td>
        <td class="input"><input name="press" type="text" class="text"  value="${book.press}"/></td>
        <td class="text"><span class="bi_tian">*</span>出版时间：</td>
        <td class="input"><input id="publishTime" name="publishTime" type="text" class="text"  value="${book.publishTime}" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>版次：</td>
        <td class="input"><input name="edition" type="text" class="text" value="${book.edition}"/></td>
        <td class="text"><span class="bi_tian">*</span>印刷时间：</td>
        <td class="input"><input id="printTime" name="printTime" type="text" class="text" value="${book.printTime}"/></td>
    </tr>    
    <tr> 
        <td class="text"><span class="bi_tian">*</span>总页数：</td>
        <td class="input"><input name="pageNum" type="text" class="text" value="${book.pageNum}"/></td>
        <td class="text"><span class="bi_tian">*</span>总字数：</td>
        <td class="input"><input name="wordNum" type="text" class="text" value="${book.wordNum}"/></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>开本：</td>
        <td class="input">
        <select name="booksize">
        	<option value="4" ${book.booksize eq 4 ? 'selected="selected"' : ''}>4开</option>
        	<option value="8" ${book.booksize eq 8 ? 'selected="selected"' : ''}>8开</option>
        	<option value="16" ${book.booksize eq 16 ? 'selected="selected"' : ''}>16开</option>
        	<option value="32" ${book.booksize eq 32 ? 'selected="selected"' : ''}>32开</option>
        </select>
        </td>
        <td class="text"><span class="bi_tian">*</span>纸质：</td>
        <td class="input">
        <select name="paper">
        	<option value="普通" ${book.paper eq '普通' ? 'selected="selected"' : ''}>普通</option>
        	<option value="胶版纸" ${book.paper eq '胶版纸' ? 'selected="selected"' : ''}>胶版纸</option>
        	<option value="铜版纸" ${book.paper eq '铜版纸' ? 'selected="selected"' : ''}>铜版纸</option>
        	<option value="新闻纸" ${book.paper eq '新闻纸' ? 'selected="selected"' : ''}>新闻纸</option>
        	<option value="轻涂纸" ${book.paper eq '轻涂纸' ? 'selected="selected"' : ''}>轻涂纸</option>
        	<option value="轻型纸" ${book.paper eq '轻型纸' ? 'selected="selected"' : ''}>轻型纸</option>
        	<option value="双胶纸" ${book.paper eq '双胶纸' ? 'selected="selected"' : ''}>双胶纸</option>
        	<option value="书写纸" ${book.paper eq '书写纸' ? 'selected="selected"' : ''}>书写纸</option>
        	<option value="书刊纸" ${book.paper eq '书刊纸' ? 'selected="selected"' : ''}>书刊纸</option>
        </select>
        </td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>图书分类：</td>
        <td class="input">
		<select name="categoryId">
  			<c:forEach var="category" items="${categoryList}" varStatus="s">
  				<option value="${category.id}" ${book.categoryId eq category.id ? 'selected="selected"' : ''}>${category.name}</option>
			</c:forEach>
		</select>
		</td>
        <td class="text"><span class="bi_tian">*</span>排序索引：</td>
        <td class="input"><input name="orderIndex" type="text" class="text" value="${book.orderIndex}" /></td>
    </tr>
	<tr> 
        <td class="text" ><span class="bi_tian">*</span>描述：</td>
        <td class="input" colspan="4">
        <script type="text/plain" id="myEditor" name="description" style="width:900px;height:300px;">${book.description}</script>
        </td>
    </tr>
	<tr>         
        <td class="text"></td>
	    <td class="submit">
		<input type="submit" name="submit" value="确认修改" class="submit" /></td>
    </tr>
  </table>
  <br>
  <br>
</form>
<script type="text/javascript">
    var um = UM.getEditor('myEditor');
</script>
</body>
</html>