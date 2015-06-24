<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>后台登录-在线管理系统</title>
        <!-- base href="http://localhost/test/" -->
    <link rel="stylesheet" type="text/css" href="${base}/styles/admin/a.css">
    <script type="text/javascript" src="${base}/styles/admin/a.js"></script>
    <script type="text/javascript" src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>	
</head>

<body class="loginWeb">
    <div class="loginBox">
        <div class="innerBox">
            <div class="logo"><h1>后台管理系统</h1></div>
            <form id="myform" action="${base}/adminCheck.htm" method="post">
                <div class="loginInfo">
                    <ul>
                        <li class="row1">登录账号：</li>
                        <li class="row2"><input class="input" name="username" id="username" size="30" type="text"></li>
                    </ul>
                    <ul>
                        <li class="row1">登录密码：</li>
                        <li class="row2"><input class="input" name="password" id="password" size="30" type="password"></li>
                    </ul>
                </div>
                <input name="op_type" id="op_type" value="1" type="hidden">
            </form>
            <div class="clear"></div>
            <div class="operation"><button class="btn submit" onclick="sub();">登录</button> 
            </div>
        </div>
    </div>

    <script type="text/javascript">
        function sub(){
         	$("#myform").submit();
        };
    </script>

</body></html>