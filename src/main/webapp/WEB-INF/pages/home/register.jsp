<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>注册-在线书店</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${base}/styles/bootstrap/css/bootstrap-theme.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${base}/styles/bootstrap/js/jquery-1.7.2.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${base}/styles/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${base}/css/signin.css">
</head>
 <body>

    <div class="container">

      <form class="form-signin" action="${base}/registerCheck.htm">
        <h2 class="form-signin-heading">请注册</h2>
        <label for="inputUsername" class="sr-only">用户名　</label>
        <input style="margin-bottom:10px;" type="text" id="inputUsername" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputCnname" class="sr-only">中文名　</label>
        <input style="margin-bottom:10px;" type="text" id="inputCnname" name="cnname" class="form-control" placeholder="中文名" required autofocus>
        <label for="inputPassword" class="sr-only">密　码　</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <label for="inputPassword2" class="sr-only">确认密码</label>
        <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="确认密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
         	<a href="${base}/index.htm">首页</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="${base}/login.htm">登录</a>
      </form>

    </div> <!-- /container -->
</body>
</html>