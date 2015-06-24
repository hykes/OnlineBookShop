<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>订单详情-在线书店</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<script src="<c:url value='${base}/js/round.js'/>"></script>
<link rel="stylesheet" type="text/css" href="${base}/css/cartList.css">
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
/* stepInfo 
	border-radius：0为正方形，0~N，由正方形向圆形转化，N越大越圆。
	padding：图形的内边距
	background：图形背景色
	text-align：文本对齐
	line-height：行高
	color：文字颜色
	position：定位
	width：宽度
	height：高度
*/
.stepInfo{position:relative;background:#f2f2f2;margin:20px auto 0 auto;width:500px;}
.stepInfo li{float:left;width:48%;height:0.15em;background:#bbb;}
.stepIco{border-radius:1em;padding:0.03em;background:#bbb;text-align:center;line-height:1.5em;color:#fff; position:absolute;width:1.4em;height:1.4em;}
.stepIco1{top:-0.7em;left:-1%;}
.stepIco2{top:-0.7em;left:21%;}
.stepIco3{top:-0.7em;left:46%;}
.stepIco4{top:-0.7em;left:71%;}
.stepIco5{top:-0.7em;left:95%;}
.stepText{color:#666;margin-top:0.2em;width:4em;text-align:center;margin-left:-1.4em;}
</style>
<script type="text/javascript">
$(function() {
	setTimeout("changeDivStyle();", 100); // 0.1秒后展示结果，因为HTML加载顺序，先加载脚本+样式，再加载body内容。所以加个延时
});
function changeDivStyle(){
	var o_status = ${order.status}+1;
	if(o_status==0){
		$('#create').css('background', '#DD0000');
		$('#createText').css('color', '#DD0000');
	}else if(o_status==1||o_status==2){
		$('#check').css('background', '#DD0000');
		$('#checkText').css('color', '#DD0000');
	}else if(o_status==3){
		$('#produce').css('background', '#DD0000');
		$('#produceText').css('color', '#DD0000');
	}else if(o_status==4){
		$('#delivery').css('background', '#DD0000');
		$('#deliveryText').css('color', '#DD0000');
	}else if(o_status>=5){
		$('#received').css('background', '#DD0000');
		$('#receivedText').css('color', '#DD0000');
	}
}
</script>

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
           	<li><a href="${base}/loginOut.jsp">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="图书名称" class="form-control">
			</div>
            <button type="submit" class="btn btn-success">搜索</button>
          </form>
        </div>
      </div>
    </nav>
<div class="col-sm-12 col-md-12" style="margin-top:60px;margin-bottom: 10px;">
	<div class="container">
	<div class="stepInfo">
	<ul>
		<li></li>
		<li></li>
	</ul>
	<div class="stepIco stepIco1" id="create">1
		<div class="stepText" id="createText">创建订单</div>
	</div>
	<div class="stepIco stepIco2" id="check">2
		<div class="stepText" id="checkText">订单支付</div>
	</div>
	<div class="stepIco stepIco3" id="produce">3
		<div class="stepText" id="produceText">生产</div>
	</div>
	<div class="stepIco stepIco4" id="delivery">4
		<div class="stepText" id="deliveryText">配送</div>
	</div>
	<div class="stepIco stepIco5" id="received">5
		<div class="stepText" id="receivedText">完成交易</div>
	</div>
</div>
	
	</div>
	<div class="container">
		订单编号：${order.id}&nbsp;&nbsp;状态：
		<c:if test="${order.status eq 1}">未付款</c:if>
		<c:if test="${order.status eq 2}">已付款但未发货</c:if>
		<c:if test="${order.status eq 3}">已发货未确认收货</c:if>
		<c:if test="${order.status eq 4}">交易完成</c:if>
		<c:if test="${order.status eq 5}">已取消</c:if>
	</div>
</div>
<div class="container">
<table width="100%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td width="100px"></td>		
		<td width="100px">图书编号</td>		
		<td>图书名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
	</tr>
<c:forEach items="${orderItemList}" var="orderItem">
	<tr align="center">
		<td align="center" width="100px">
			<a class="linkImage" href="${base}/details.htm?id=${orderItem.bookId}"><img border="0" width="54" align="top" src="${base}${orderItem.imagePath}"/></a>
		</td>
		<td align="center" width="100px">
		    <span>${orderItem.bookId}</span>
		</td>
		<td align="center" width="300px">
		    <a href="${base}/details.htm?id=${orderItem.bookId}" title="${orderItem.bookName}"><span>${fn:substring(orderItem.bookName, 0, 15)}</span></a>
		</td>
		<td><span>&yen;<span class="currPrice">${orderItem.currPrice}</span></span></td>
		<td>
			<span>${orderItem.quantity}</span>
		</td>
		<td width="100px">
			<span>￥${orderItem.subtotal}</span>
		</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="4" class="tdTotal">
		</td>
		<td colspan="4" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;${order.total}</span>
		</td>
	</tr>
	<c:if test="${order.status eq 1 }">
	<tr>
		<form id="zhifuform" action="${base}/home/order/pay.htm" method="post">
		<input type="hidden" name="orderId" id="orderId">
		<td colspan="4">收货地址：<input type="text" name="address" id="address"></td>
		<td colspan="4" align="right">
			<a href="javascript:zhifu(${order.id});" id="jiesuan" style="height: 40px;width: 190px;margin: 0px; font-size: 20px;">支付订单</a>
		</td>
		</form>
	</tr>
	</c:if>
	<c:if test="${order.status eq 3 }">
	<tr>
		<td colspan="8" align="right">
			<a href="${base}/home/order/shouhuo.htm?id=${order.id}" id="jiesuan" style="height: 40px;width: 190px;margin: 0px; font-size: 20px;">确认收货</a>
		</td>
	</tr>
	</c:if>
</table>
</div>
<script type="text/javascript">
function zhifu(id) {
	if($("#address").val()==''){
		alert("请填写地址！");
	}else{
		$("#orderId").val(id);
		$("#zhifuform").submit();
	}

}
</script>
</body>
</html>