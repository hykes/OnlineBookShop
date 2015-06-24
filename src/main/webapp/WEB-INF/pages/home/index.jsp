<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>在线书店</title>
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
	<div class="container" style="padding:0;">
		<div class="col-xs-4 col-sm-3 sidebar-offcanvas" id="sidebar" style="margin-top: 10px;">
          <div class="list-group">
            <a href="#" class="list-group-item active">图书分类</a>
            <c:forEach varStatus="s" items="${categoryList}" var="cate">
            <a href="${base}/list.htm?id=${cate.id}" class="list-group-item">${cate.name}</a>
            </c:forEach>
            <a href="${base}/category.htm" class="list-group-item">更多分类</a>
          </div>
        </div>
		<div class="col-xs-4 col-sm-9">
    		<div id="myCarousel" class="carousel slide" data-ride="carousel">
      			<!-- Indicators -->
      			<ol class="carousel-indicators">
        		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        		<li data-target="#myCarousel" data-slide-to="1"></li>
        		<li data-target="#myCarousel" data-slide-to="2"></li>
      			</ol>
	  
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="${base}/images/1.jpg" alt="First slide">
        </div>
        <div class="item">
          <img class="second-slide" src="${base}/images/2.jpg" alt="Second slide">
        </div>
        <div class="item">
          <img class="third-slide" src="${base}/images/3.jpg" alt="Third slide">
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
</div>
	</div>

    <div class="container">
	 <hr class="featurette-divider">
      <div class="row">
				<div class="col-xs-12">
					<!-- START CONTENT ITEM -->
					<div class="product-list-inline-large">
					<c:forEach items="${bookList}" var="book" varStatus="s">
						<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
							<div class="thumbnail ">
								<a href="${base}/details.htm?id=${book.id}">
									<div class="label label-info price">￥${book.currPrice}</div>
									<img src="${base}${book.imagePath}" alt="${book.name}" style="width: 220px; height: 230px;">
								</a>
								<div class="caption">
									<a href="${base}/details.htm?id=${book.id}" title="${book.name}">${fn:substring(book.name, 0, 15)}</a>
								</div>
								<a href="javascript:void(0);" onclick="addCart(${book.id});" class="btn btn-danger" style="margin: 0px 0px -20px 20px;">加入购物车</a><a href="${base}/home/cart/oneClickBuy.htm?id=${book.id}" class="btn btn-warning" style="margin: 0px 0px -20px 20px;">一键购买</a>
							</div>
						</div>
					</c:forEach>
					</div>
					<!-- END CONTENT ITEM -->
				</div>
			</div>
    </div>
	<%@ include file="/footerBar.jsp"%>
<script type="text/javascript">
function addCart(bookId) {
	$.ajax({
		async:false,
		cache:false,
		url:"${base}/home/cart/addCart.htm",
		data:{bookId:bookId},
		type:"POST",
		dataType:"json",
		success:function(result) {
			if(result.msg==0){
				alert("该图书已在购物车中！");
			}
			if(result.msg==-1){
				alert("加入购物车出错！");
			}
			if(result.msg==1){
				alert("该图书已加入购物车！");
			}
		},
		error: function(err){
			alert("请登录后进行购物车操作！");
			location.href = "${base}/login.htm";
		}
	});
}
</script>
<script src="${base}/js/holder.js"></script>
</body>
</html>