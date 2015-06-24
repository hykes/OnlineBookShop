<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/home/order/list.htm" />
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
            <li class="active"><a href="${base}/home/order/list.htm">我的订单</a></li>
            <li><a href="${base}/home/user/updatePwd.htm">修改密码</a></li>
            <li><a href="${base}/home/user/info.htm">我的资料</a></li>
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

<div class="col-sm-12 col-md-12">
      <div class="container">
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th style="width: 120px;">订单编号</th>
                  <th style="width: 250px;">下单时间</th>
                  <th style="width: 150px;">订单总价</th>
                  <th style="width: 250px;">订单状态</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
             	<c:forEach items="${page.list}" var="order" varStatus="s">
                <tr>
                  <td>${order.id}</td>
                  <td><fmt:formatDate value="${order.createTime}" pattern="yyyy/MM/dd-HH:mm:ss" /></td>
                  <td>￥${order.total}</td>
                  <td>
                  	<c:if test="${order.status eq 1}">未付款</c:if>
                  	<c:if test="${order.status eq 2}">已付款但未发货</c:if>                  
                  	<c:if test="${order.status eq 3}">已发货未确认收货</c:if>                  
                  	<c:if test="${order.status eq 4}">交易完成</c:if>
                  	<c:if test="${order.status eq 5}">已取消</c:if>				
				  </td>
                  <td><a href="${base}/home/order/details.htm?id=${order.id}">详情</a><span>|</span>
                  	<c:if test="${order.status eq 1}"><a href="${base}/home/order/del.htm?id=${order.id}">取消订单</a></c:if>
                  	<c:if test="${order.status eq 2}"></c:if>
                  	<c:if test="${order.status eq 3}"><a href="${base}/home/order/shouhuo.htm?id=${order.id}">确认收货</a></c:if>
                  	<c:if test="${order.status eq 4}"></c:if>
                  	<c:if test="${order.status eq 5}"></c:if>
                  </td>
                </tr>            	
             	</c:forEach>
              </tbody>
            </table>
          </div>
				<nav>
					<!-- START CONTENT ITEM -->
					<ul class="pagination">
						<li><a href="${pagePath}?p=1">首页</a></li>
						<c:choose>
							<c:when test="${page.currentPage>1}">
								<li><a href="${pagePath}?p=${page.currentPage-1}">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">上一页</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${page.currentPage<page.totalPage}">
								<li><a href="${pagePath}?p=${page.currentPage+1}">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">下一页</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="${pagePath}?p=${page.totalPage}">尾页</a></li>
					</ul>
					<!-- END CONTENT ITEM -->
				</nav>
        </div>
    </div>

</body>
</html>