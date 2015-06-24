<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>登录-在线书店</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${base}/css/signin.css">
    <script type="text/javascript">      
        $(function(){         
        $('#kaptchaImage').click(function () {//生成验证码  
             $(this).hide().attr('src', '${base}/captcha-image.htm?' + Math.floor(Math.random()*100) ).fadeIn();  
             event.cancelBubble=true;  
            });  
        });   
   </script>
</head>
 <body>

    <div class="container">

      <form class="form-signin" action="${base}/loginCheck.htm">
        <h2 class="form-signin-heading">请登录${msg}</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input style="margin-bottom:10px;" type="text" id="inputUsername" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密　码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <div class="form-inline" style="margin-bottom: 5px">
            <label for="inputKaptcha" class="sr-only">验证码</label>
            <input type="text" id="inputKaptcha" name="kaptcha" class="form-control" placeholder="验证码" required>&nbsp;&nbsp;
            <img src="${base}/captcha-image.htm" id="kaptchaImage"  />
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
         	<a href="${base}/index.htm">首页</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="${base}/register.htm">注册</a>
      </form>

    </div> <!-- /container -->
</body>
</html>