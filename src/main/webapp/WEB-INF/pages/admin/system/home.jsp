<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻发布系统后台管理</title>
<link href="${base}/styles/admin/metinfo.css" rel="stylesheet" />
<link href="${base}/styles/admin/base.css" rel="stylesheet" />
<link href="${base}/styles/admin/indexbody.css" rel="stylesheet" />
</head>
<script type="text/javascript" src="${base}/style/js/jquery-1.10.2.min.js"></script>
<body>
<div>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
     <div style='float:left'></div><div id='' style='float:right;padding-right:8px;'></div>
   </td>
  </tr>
  <tr>
    <td height="1" background="images/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<div id='mainmsg'>
  <div class="column" id="column1"><!--左侧开始-->      
        <dl class='dbox' id="item6">
            <dt class='lside'><div class='l'>信息统计</div></dt>
            <dd id='listCount'>
                <table width="100%" class="dboxtable">
                    <tbody>
                    <tr>
                        <td width="50%" class="nline" style="text-align:left"> 用户总量： </td>
                        <td class="nline" style="text-align:left"> ${userCount} </td>
                    </tr>
                    <tr>
                        <td class="nline" style="text-align:left"> 图书总量： </td>
                        <td class="nline" style="text-align:left"> ${bookCount} </td>
                    </tr>
                    <tr>
                        <td class="nline" style="text-align:left"> 订单总量： </td>
                        <td class="nline" style="text-align:left"> ${orderCount}</td>
                    </tr>
                    </tbody>
                </table>
           </dd>
        </dl><!--信息统计结束-->
    </div><!--左侧结束-->
    <div class="column" id="column2" ><!-- //右边的快捷消息开始 -->
        <dl class='dbox' id="item7">
            <dt class='lside'><div class='l'>新上架图书</div></dt>
            <dd id='listNews'>
                <table width="100%" class="dboxtable">
                   <tr>
                    <td class="nline" style="text-align:left">
                        暂无新增内容
                    </td>
                   </tr>
                </table>
            </dd>
        </dl><!--最新文档结束-->
    </div>
</div>
</div>
</div>
</body>
</html>