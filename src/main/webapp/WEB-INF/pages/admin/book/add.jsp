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
		<li class="now"><a href="${base}/admin/book/add.htm" title="添加图书">添加图书</a></li>
	</ul>
</div>
<form method="POST" enctype="multipart/form-data" name="myform" action="${base}/admin/book/saveAdd.htm" target="_self">
  <table cellpadding="2" cellspacing="1" class="table">
    <tr> 
        <td class="text"><span class="bi_tian">*</span>图书名称：</td>
        <td class="input"><input name="name" type="text" class="text" /></td>       
        <td class="text"><span class="bi_tian">*</span>作者：</td>
        <td class="input"><input name="author" type="text" class="text" /></td>
    </tr>
    <tr>         
        <td class="text"><span class="bi_tian">*</span>价格：</td>
        <td class="input"><input name="price" type="text" class="text" /></td>
        <td class="text"><span class="bi_tian">*</span>折扣：</td>
        <td class="input">
        <select name="discount">
        	<option value="1">无折扣</option>
        	<option value="0.95">95折</option>
        	<option value="0.9">9折</option>
        	<option value="0.85">85折</option>
        	<option value="0.8">8折</option>
        	<option value="0.75">75折</option>
        	<option value="0.7">7折</option>
        	<option value="0.65">65折</option>
        	<option value="0.6">6折</option>
        </select>        
        </td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>出版社：</td>
        <td class="input"><input name="press" type="text" class="text" /></td>
        <td class="text"><span class="bi_tian">*</span>出版时间：</td>
        <td class="input"><input id="publishTime" name="publishTime" type="text" class="text" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>版次：</td>
        <td class="input"><input name="edition" type="text" class="text" /></td>
        <td class="text"><span class="bi_tian">*</span>印刷时间：</td>
        <td class="input"><input id="printTime" name="printTime" type="text" class="text" /></td>
    </tr>    
    <tr> 
        <td class="text"><span class="bi_tian">*</span>总页数：</td>
        <td class="input"><input name="pageNum" type="text" class="text" /></td>
        <td class="text"><span class="bi_tian">*</span>总字数：</td>
        <td class="input"><input name="wordNum" type="text" class="text" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>开本：</td>
        <td class="input">
        <select name="booksize">
        	<option value="4">4开</option>
        	<option value="8">8开</option>
        	<option value="16">16开</option>
        	<option value="32">32开</option>
        </select>
        </td>
        <td class="text"><span class="bi_tian">*</span>纸质：</td>
        <td class="input">
        <select name="paper">
        	<option value="普通">普通</option>
        	<option value="胶版纸">胶版纸</option>
        	<option value="铜版纸">铜版纸</option>
        	<option value="新闻纸">新闻纸</option>
        	<option value="轻涂纸">轻涂纸</option>
        	<option value="轻型纸">轻型纸</option>
        	<option value="双胶纸">双胶纸</option>
        	<option value="书写纸">书写纸</option>
        	<option value="书刊纸">书刊纸</option>
        </select>
        </td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>图片：</td>
        <td class="input">
        	<input type="file" name="myFile"/>
        </td>
        <td class="text"><span class="bi_tian">*</span>图书分类：</td>
        <td class="input">
		<select name="categoryId">
  			<c:forEach var="category" items="${categoryList}" varStatus="s">
  				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr> 
        <td class="text"><span class="bi_tian">*</span>排序索引：</td>
        <td class="input"><input name="orderIndex" type="text" class="text" value="1" /></td>
    </tr>
	<tr> 
        <td class="text" ><span class="bi_tian">*</span>描述：</td>
        <td class="input" colspan="4">
        <script type="text/plain" id="myEditor" name="description" style="width:900px;height:300px;"></script>
        </td>
    </tr>
	<tr>         
        <td class="text"></td>
	    <td class="submit">
		<input type="submit" name="submit" value="确认添加" class="submit" /></td>
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