<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>	
	<link href="${base}/styles/admin/metinfo.css" rel="stylesheet" />
<script type="text/javascript" src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>	
</head>
<body>
<div class="stat_list">
	<ul>
		<li class="now"><a href="#" title="修改密码">修改密码</a></li>
		<li><div class="info"></div></li>
	</ul>
</div>
<form method="POST" id="myform" action="${base}/admin/system/saveUpdatePwd.htm" target="_self" >
<table cellpadding="2" cellspacing="1" class="table">
    <tr> 
        <td class="text"><span class="bi_tian">*</span>当前密码：</td>
        <td class="input"><input name="password" id="password" type="text" class="text" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>新设密码：</td>
        <td class="input"><input name="newpassword" id="newpassword" type="text" class="text" /></td>
    </tr>
    <tr> 
        <td class="text"><span class="bi_tian">*</span>确认密码：</td>
        <td class="input"><input name="newpassword2" id="newpassword2" type="text" class="text" /></td>
    </tr>
	<tr> 
        <td class="text"></td>
	    <td class="submit">
		<input type="button"  onclick="checkPwd();" value="确认修改" class="submit" /></td>
    </tr>
  </table>
</form>
<script type="text/javascript">
$(document).ready(function(){
	<!--当前密码验证-->
	 $("#password").focus(function()
	 {
		   if($(this).val().length==0)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入当前密码！");
	        }
	 });
	 
	 $("#password").blur(function()
	 {
		   	if($(this).val().length==0)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入当前密码！");
	        }else{
	        	$(".info").text("");
	        }
	 });
	<!--第一次密码验证-->
	 $("#newpassword").focus(function()
	 {
		   if($(this).val().length<6||$(this).val().length>16)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入6-16位新设密码，不含空格！");
	        }
	 });
	 
	 $("#newpassword").blur(function()
	 {
		   	if($(this).val().length<6||$(this).val().length>16)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入6-16位新设密码，不含空格！");
	        }else{
	        	$(".info").text("");
	        }
	 });
	<!--第二次密码验证-->
	 $("#newpassword2").focus(function()
	 {
		   if($(this).val().length<6||$(this).val().length>16)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入6-16位确认密码，不含空格！");
	        }
	 });
	 
	 $("#newpassword2").blur(function()
	 {
		   	if($(this).val().length<6||$(this).val().length>16)
	        {
	            $(".info").css("color","#4DAFE4").text("请输入6-16位确认密码，不含空格！");
	        }else{
	        	$(".info").text("");
	        }
	 });
});
function checkPwd(){
	 if($("#newpassword").val()!=$("#newpassword2").val()){
		 alert("两次密码不一致");
	 }else{
		 $("#myform").submit();
	 }
}
</script>
</body>
</html>