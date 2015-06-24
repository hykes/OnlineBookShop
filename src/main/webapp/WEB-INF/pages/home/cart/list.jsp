<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>我的购物车-OnlineBookShop</title>
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
<script type="text/javascript">
$(function() {
	showTotal();//计算总计
	
	/*
	给全选添加click事件
	*/
	$("#selectAll").click(function() {
		/*
		1. 获取全选的状态
		*/
		var bool = $("#selectAll").prop("checked");
		/*
		2. 让所有条目的复选框与全选的状态同步
		*/
		setItemCheckBox(bool);
		/*
		3. 让结算按钮与全选同步
		*/
		setJieSuan(bool);
		/*
		4. 重新计算总计
		*/
		showTotal();
	});
	
	/*
	给所有条目的复选框添加click事件
	*/
	$(":checkbox[name=checkboxBtn]").click(function() {
		var all = $(":checkbox[name=checkboxBtn]").length;//所有条目的个数
		var select =$('input[name="checkboxBtn"]:checked').length;//获取所有被选择条目的个数
		if(all == select) {//全都选中了
			$("#selectAll").attr("checked", true);//勾选全选复选框
			setJieSuan(true);//让结算按钮有效
		} else if(select == 0) {//谁都没有选中
			$("#selectAll").attr("checked", false);//取消全选
			setJieSuan(false);//让结算失效
		} else {
			$("#selectAll").attr("checked", false);//取消全选
			setJieSuan(true);//让结算有效				
		}
		showTotal();//重新计算总计
	});
	
	/*
	给减号添加click事件
	*/
	$(".jian").click(function() {
		// 获取cartItemId
		var id = $(this).attr("id").substring(4);
		// 获取输入框中的数量
		var quantity = $("#" + id + "Quantity").val();
		// 判断当前数量是否为1，如果为1,那就不是修改数量了，而是要删除了。
		if(quantity == 1) {
			if(confirm("数量小于0,您是否要删除该条目？")) {
				location = "${base}/home/cart/del.htm?id=" + id;
			}
		} else {
			sendUpdateQuantity(id, quantity-1);
		}
	});
	
	// 给加号添加click事件
	$(".jia").click(function() {
		// 获取cartItemId
		var id = $(this).attr("id").substring(3);
		// 获取输入框中的数量
		var quantity = $("#" + id + "Quantity").val();
		sendUpdateQuantity(id, Number(quantity)+1);
	});
});

// 请求服务器，修改数量。
function sendUpdateQuantity(id, quantity) {
	$.ajax({
		async:false,
		cache:false,
		url:"${base}/home/cart/updateQuantity.htm",
		data:{id:id,quantity:quantity},
		type:"POST",
		dataType:"json",
		success:function(result) {
			//1. 修改数量
			$("#" + id + "Quantity").val(result.quantity);
			//2. 修改小计
			$("#" + id + "Subtotal").text(result.subtotal);
			//3. 重新计算总计
			showTotal();
		}
	});
}

/*
 * 计算总计
 */
function showTotal() {
	var total = 0;
	/*
	1. 获取所有的被勾选的条目复选框！循环遍历之
	*/
	$('input[name="checkboxBtn"]:checked').each(function() {
		//2. 获取复选框的值，即其他元素的前缀
		var id = $(this).val();
		//3. 再通过前缀找到小计元素，获取其文本
		var text = $("#" + id + "Subtotal").text();
		//4. 累加计算
		total += Number(text);
	});
	// 5. 把总计显示在总计元素上
	$("#total").text(round(total, 2));//round()函数的作用是把total保留2位
}

/*
 * 统一设置所有条目的复选按钮
 */
function setItemCheckBox(bool) {
	$(":checkbox[name=checkboxBtn]").attr("checked", bool);
}

/*
 * 设置结算按钮样式
 */
function setJieSuan(bool) {
	if(bool) {
		$("#jiesuan").unbind("click");//撤消当前元素止所有click事件
	} else {
		$("#jiesuan").click(function() {return false;});
	}
	
}

/*
 * 批量删除
 */
function batchDelete() {
	// 1. 获取所有被选中条目的复选框
	// 2. 创建一数组，把所有被选中的复选框的值添加到数组中
	// 3. 指定location为CartItemServlet，参数method=batchDelete，参数cartItemIds=数组的toString()
	var cartItemIdArray = new Array();
	$('input[name="checkboxBtn"]:checked').each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});
	location = "#" + cartItemIdArray;
}

/*
 * 结算
 */
function jiesuan() {
	// 1. 获取所有被选择的条目的id，放到数组中
	var cartItemIdArray = new Array();
	$('input[name="checkboxBtn"]:checked').each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});	
	// 2. 把数组的值toString()，然后赋给表单的cartItemIds这个hidden
	$("#cartItemIds").val(cartItemIdArray.toString());
	// 把总计的值，也保存到表单中
	$("#hiddenTotal").val($("#total").text());
	$("#jieSuanForm").submit();
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
            <li class="active"><a href="${base}/home/cart/list.htm">我的购物车</a></li>
            <li><a href="${base}/home/order/list.htm">我的订单</a></li>
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
	<c:choose>
	<c:when test="${empty cartItemList }">
	<div class="container">
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="${base}/images/icon_empty.png"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>
	</div>  
	</c:when>
	<c:otherwise>
	<div class="container">
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label>
		</td>
		<td width="100px"></td>		
		<td width="100px">图书编号</td>		
		<td>图书名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>

<c:forEach items="${cartItemList}" var="cartItem">
	<tr align="center">
		<td align="center">
			<input value="${cartItem.id}" type="checkbox" name="checkboxBtn" checked="checked"/>
		</td>
		<td align="center" width="100px">
			<a class="linkImage" href="${base}/details.htm?id=${cartItem.bookId}"><img border="0" width="54" align="top" src="${base}${cartItem.imagePath}"/></a>
		</td>
		<td align="center" width="100px">
		    <span>${cartItem.bookId}</span>
		</td>
		<td align="center" width="300px">
		    <a href="${base}/details.htm?id=${cartItem.bookId}" title="${cartItem.bookName}"><span>${fn:substring(cartItem.bookName, 0, 15)}</span></a>
		</td>
		<td><span>&yen;<span class="currPrice">${cartItem.currPrice}</span></span></td>
		<td>
			<a class="jian" id="Jian${cartItem.id}"></a><input class="quantity" readonly="readonly" id="${cartItem.id}Quantity" type="text" value="${cartItem.quantity}"/><a class="jia" id="Jia${cartItem.id}"></a>
		</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartItem.id}Subtotal">${cartItem.total}</span></span>
		</td>
		<td>
			<a href="${base}/home/cart/del.htm?id=${cartItem.id}">删除</a>
		</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="8" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="8" align="right">
			<a href="javascript:jiesuan();" id="jiesuan" style="height: 40px;width: 190px;margin: 0px; font-size: 20px;">下单</a>
		</td>
	</tr>
</table>
	<form id="jieSuanForm" action="${base}/home/cart/xiadan.htm" method="post">
		<input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="total" id="hiddenTotal"/>
		<input type="hidden" name="address" id="hiddenAddress"/>
	</form>
</div>
	</c:otherwise>
</c:choose>

  </body>
</html>