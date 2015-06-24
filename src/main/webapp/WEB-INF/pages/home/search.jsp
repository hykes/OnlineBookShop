<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<c:set var="pagePath" value="${base}/search.htm?bookName=${bookName}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>搜索列表-在线书店</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<link href="${base}/css/carousel.css" rel="stylesheet">
<link href="${base}/css/details.css" type="text/css" rel="stylesheet">
</head>
  <body>
	<%@ include file="/topBar.jsp"%>
	<%@ include file="/menuBar.jsp"%>
	<div class="container">
	<div class="col-xs-12 col-sm-12" style="margin-top: 20px;">
	搜索结果:${count}条记录...
	</div>
		<div class="col-xs-12 col-sm-12" style="margin-top: 20px;">
			<!-- START CONTENT ITEM -->
			<div class="row">
				<div class="col-xs-12">
					<div class="row product-list-inline-small">
						<c:forEach items="${page.list}" var="book" varStatus="s">
							<div class="col-xs-3 col-sm-3">
								<div class="thumbnail">
									<a href="${base}/details.htm?id=${book.id}"><img
										src="${base}${book.imagePath}" alt="${book.name}" style="width: 220px; height: 270px;"></a>
									<div class="caption">
										<a href="${base}/details.htm?id=${book.id}" title="${book.name}">${fn:substring(book.name, 0, 15)}</a>
										<p>
											<span class="label label-primary price pull-right">￥${book.currPrice}
											</span>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- END CONTENT ITEM -->
			<div class="row">
				<div class="col-xs-12">
					<ul class="pagination pull-right">
						<li><a href="${pagePath}&p=1">首页</a></li>
						<c:choose>
							<c:when test="${page.currentPage>1}">
								<li><a href="${pagePath}&p=${page.currentPage-1}">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">上一页</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${page.currentPage<page.totalPage}">
								<li><a href="${pagePath}&p=${page.currentPage+1}">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">下一页</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="${pagePath}&p=${page.totalPage}">尾页</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/footerBar.jsp"%>
</body>
</html>