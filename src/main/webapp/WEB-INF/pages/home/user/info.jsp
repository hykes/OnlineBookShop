<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>我的订单-OnlineBookShop</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<link href="${base}/css/dashboard.css" rel="stylesheet">
</head>
   <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${base}/index.htm" style="color:#FFF">OnlineBookShop</a>
        </div>
		<div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${base}/home/cart/list.htm">我的购物车</a></li>
            <li><a href="${base}/home/order/list.htm">我的订单</a></li>
            <li><a href="${base}/home/user/updatePwd.htm">修改密码</a></li>
            <li class="active"><a href="${base}/home/user/info.htm">我的资料</a></li>
           	<li><a href="${base}/loginOut.htm">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="图书名称" class="form-control">
			</div>
            <button type="submit" class="btn btn-success">搜索</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <div class="container">
    <div class="container">
    <h3 class="sub-header">个人资料</h3>
	<form method="post" style="max-width: 400px;" name="form1" action="${base}/home/user/saveInfo.htm" >
		<input type="hidden" value="1" name="id">
		<input type="hidden" value="hehaiyang" name="username">
		<div class="input-group ">
  			<span class="input-group-addon">用户ID</span>
  			<label class="form-control">${user.id}</label>
		</div>
		<div class="input-group">
  			<span class="input-group-addon">用户名</span>
  			<label class="form-control">${user.username}</label>
		</div>	
		<div class="input-group">
  			<span class="input-group-addon">中文名</span>
  			<input type="text" class="form-control" name="cnname" value="${user.cnname}">
		</div>	
		<div class="input-group">
  			<span class="input-group-addon">邮　箱</span>
  			<input type="text" class="form-control"  name="email" value="${user.email}">
		</div>	
		<div class="input-group">
  			<span class="input-group-addon">电　话</span>
  			<input type="text" class="form-control"  name="phone" value="${user.phone}">
		</div>	
		<div class="input-group">
  			<span class="input-group-addon">地　址</span>
  			<input type="text" class="form-control" name="address" value="${user.address}">
		</div>
		<br>
		<button type="submit" class="btn btn-success">更新信息</button>								
	</form>

	</div><!-- /.container -->
    </div>

</body>
</html>