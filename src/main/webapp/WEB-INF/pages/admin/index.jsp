<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业网站管理系统</title>
<link rel="shortcut icon" href="${base}/favicon.ico">
<link href="${base}/styles/admin/metinfo.css" rel="stylesheet" />
<script type="text/javascript" src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>
</head>

<body>
<div id="metcmsbox">
<div id="top"> 
    <div class="floatr">
	  <div class="top-r-box">
		<div class="top-right-boxr" style="float:right;">
			<div class="top-r-t">
			 	<li class="list"><a href="javascript:logout();" ><span class="c8"></span>退出系统</a></li>
			</div>
		</div>
		<div class="nav">
          <ul id="topnav">
            <li id="metnav_1" class="list"><a href="javascript:;" id="nav_1" class="onnav" hidefocus="true"><span class="c1"></span>系统中心</a></li>
			<li id="metnav_2" class="list"><a href="javascript:;" id="nav_2"  hidefocus="true"><span class="c3"></span>分类管理</a></li>
            <li id="metnav_3" class="list"><a href="javascript:;" id="nav_3"  hidefocus="true"><span class="c6"></span>图书管理</a></li>
            <li id="metnav_4" class="list"><a href="javascript:;" id="nav_4"  hidefocus="true"><span class="c4"></span>订单管理</a></li>
            <li id="metnav_5" class="list"><a href="javascript:;" id="nav_5"  hidefocus="true"><span class="c7"></span>用户管理</a></li>
          </ul>
		</div>
	  </div>
    </div>
    <div class="floatl">
	    <a href="#" hidefocus="true" id="met_logo"><img src="${base}/styles/admin/images/logo.png"/></a>
	</div>
</div>

<div id="content">
    <div class="floatl" id="metleft">
        <div class="fast">
	        <a  href="${base}/index.htm" id="qthome" title="网站首页" target="_blank">网站首页</a>
			<span></span>
			<a href="${base}/admin/index.htm" id="hthome" title="后台首页">后台首页</a>
		</div>
	    <div class="nav_list" id="leftnav">
            <ul  id="ul_1">
                <li ><a href="<c:url value='/admin/system/home.htm' />" target='main' id='nav_1_1' class="on" title="系统信息" hidefocus="true">系统信息</a></li>
                <li ><a href="<c:url value='/admin/system/updatePwd.htm' />" target='main' id='nav_1_2'   title="修改密码" hidefocus="true">修改密码</a></li>
            </ul>      
            
            <ul style="display:none;" id="ul_2">
                <li ><a href="<c:url value='/admin/category/list.htm' />" target='main' id='nav_2_1' class="on" title="分类列表" hidefocus="true">分类列表</a></li>            
                <li ><a href="<c:url value='/admin/category/add.htm' />" target='main' id='nav_2_2'  title="添加分类" hidefocus="true">添加分类</a></li>
            </ul>
            
            <ul style="display:none;" id="ul_3">
                <li ><a href="<c:url value='/admin/book/list.htm' />" target='main' id='nav_3_1' class="on" title="内容列表" hidefocus="true">图书列表</a></li>            
                <li ><a href="<c:url value='/admin/book/add.htm' />" target='main' id='nav_3_1' class="on" title="栏目列表" hidefocus="true">添加图书</a></li>
            </ul>
            
           <ul style="display:none;" id="ul_4">
                <li ><a href="<c:url value='/admin/order/list.htm' />" target='main' id='nav_4_1' class="on" title="查看留言内容" hidefocus="true">订单列表</a></li>
           </ul>
           
           <ul style="display:none;" id="ul_5">
                <li ><a href="<c:url value='/admin/user/list.htm' />" target='main' id='nav_5_1' class="on" title="用户列表" hidefocus="true">用户列表</a></li>
           </ul>
		</div>
    	<div class="left_footer">感谢使用<a href="#" target="_blank">@2015</a></div>
		
	</div>
    <div class="floatr" id="metright">
        <div class="iframe">
            <div class="min"><iframe height="670" width="100%" scrolling="auto" frameborder="0" id="main" name="main" src="<c:url value='/admin/system/home.htm' />" scrolling="no"></iframe></div>
        </div>
    </div>
	</div>
</div>
<script type="text/javascript">
   function logout(){
       if (confirm("您确定要退出系统吗?")){
            top.location = "${base}/loginOut.jsp";
       }
    }
</script>
<script src="${base}/styles/admin/metinfo.js" type="text/javascript"></script>
</body>
</html>