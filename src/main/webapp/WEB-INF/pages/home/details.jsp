<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书详情-在线书店</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<link href="${base}/css/carousel.css" rel="stylesheet">

<script type="text/javascript" src="${base}/js/jquery.Spinner.js"></script>
<script type="text/javascript" src="${base}/styles/zoom/mzp-packed.js"></script>

<link href="${base}/styles/zoom/magiczoomplus.css" type="text/css" rel="stylesheet">
<link href="${base}/css/details.css" type="text/css" rel="stylesheet">

<style type="text/css">
.Spinner{display:block;overflow:hidden;width:180px;margin:0 auto 15px auto;}
.Spinner .Amount{width:60px;height:40px;padding:4px 5px;line-height:40px;border-width:1px 0;border-style:solid;border-color:#d9d9d9;float:left;text-align:center;color:#565656;outline:0;}
.Spinner a{display:inline-block;width:40px;height:40px;border:1px solid #d9d9d9;background-color:#f7f7f7;float:left;cursor:pointer;outline:0;}
.Spinner a i{font-style:normal;background:url(images/BuynBtn.png) no-repeat;display:block;width:9px;height:9px;margin: 14px auto;text-indent:999999%;overflow:hidden;}
.Spinner .Decrease i{background-position:-9px -9px;}
.Spinner .Increase i{background-position:-9px -0px;}
.Spinner .DisDe i{background-position:-0px -9px;}
.Spinner .DisIn i{background-position:-0px -0px;}
</style>
<script type="text/javascript">
$(function(){
	$("#bookcount").Spinner({value:1, min:1, len:3, max:100});	
});
</script>
</head>
  <body>
	<%@ include file="/topBar.jsp"%>
	<%@ include file="/menuBar.jsp"%>
	<div class="container" style="padding:0;">
		<div class="col-xs-4 col-sm-4 sidebar-offcanvas" id="sidebar" style="margin-top: 20px;">
			<div class="t2">
				<a href="${base}${book.imagePath}" id="zoom1" class="MagicZoom MagicThumb"><img src="${base}${book.imagePath}" id="main_img" class="main_img" style="width:360px;height:360px;" /></a>
			</div>
    	</div>
    
		<div class="col-xs-12 col-sm-5 col-md-8">
  <div class="well">
    <div class="row">
      <div class="col-xs-6 col-sm-5 col-md-7">
        <h3><span>${fn:substring(book.name, 0, 15)}</span></h3><br />
        <strong>作者：</strong> <span>${book.author}&nbsp;&nbsp;著</span><br />
        <strong>出版社：</strong> <span>${book.press}</span><br />
        <strong>出版时间：</strong> <span>${book.publishTime}</span><br />
      </div>
      <div class="col-xs-6 col-sm-7 col-md-5 product-detail">
        <span class="label label-important price">￥${book.currPrice}</span>
      </div>
    </div>

    <div class="row">
      <div class="col-xs-12">
        <h3></h3>
        <h4>&nbsp;&nbsp;&nbsp;&nbsp;${book.name}</h4>
      </div>
    </div>
    <hr />

    <div class="row">
      <div class="col-xs-12 col-md-6">
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label for="count" class="col-xs-12 col-sm-4 col-md-4 col-lg-3 control-label"><strong>我要买</strong></label>
            <div class="col-xs-12 col-sm-8 col-md-8 col-lg-9">
				<div id="bookcount" class="Spinner"></div>
            </div>
          </div>
        </form>
      </div>
      <div class="col-xs-12 col-md-3">
        <a class="btn btn-block btn-danger"href="javascript:void(0);" onclick="addCart(${book.id});"  >加入购物车</a>
      </div>
      <div class="col-xs-12 col-md-3">
        <a class="btn btn-block btn-warning" href="javascript:void(0);" onclick="onclickbuy(${book.id});" >一键购买</a>
      </div>
    </div>
  </div>
</div>
</div>

  <div class="container">
  	<ul class="nav nav-tabs">
    	<li class="active"><a href="#panel-1" data-toggle="tab">图书介绍</a></li>
    	<li><a href="#panel-2" data-toggle="tab">同类图书</a></li>
  	</ul>
  <div class="tab-content">
    <div class="tab-pane fade in active" id="panel-1">
      <div class="row">
        <div class="col-md-12">
          <div class="thumbnail">
            ${book.description}
          </div>
        </div>
      </div>
    </div>
    <div class="tab-pane fade in " id="panel-2">
      <div class="row">
      <c:forEach items="${categoryBook}" var="bo">
        <div class="col-md-2">
          <div class="thumbnail">
            <a href="${base}/details.htm?id=${bo.id}" title="${book.name}"><img src="${base}${bo.imagePath}" alt="${bo.name}" style="width:160px;height: 160px;" /></a>
            <div class="caption">
              <p><a href="${base}/details.htm?id=${bo.id}" title="${book.name}">${fn:substring(bo.name, 0, 8)}</a></p>
              <p class="price"><span class="rob">￥${bo.currPrice}</span></p>
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
  </div>	
</div>
	<%@ include file="/footerBar.jsp"%>
<script type="text/javascript">
function onclickbuy() {
	var quantity=$(".Amount").val();
	location.href ="${base}/home/cart/oneClickBuy.htm?id=${book.id}&quantity="+quantity;
};
function addCart(bookId) {
	var quantity=$(".Amount").val();
	$.ajax({
		async:false,
		cache:false,
		url:"${base}/home/cart/addCart.htm",
		data:{bookId:bookId,quantity:quantity},
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
</body>
</html>