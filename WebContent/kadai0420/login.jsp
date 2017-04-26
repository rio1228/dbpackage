<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>ログイン</title>
</head>
<body>
  <div id="wrapper">
    <div id="main">
		<FORM ACTION="../login.java" method="get">
	        <p>ユーザーID</p>
	        <p><input type="text"name="user" /></p>
	        <p>Password</p>
	        <p class="pass"><input type="password" name="pass" /></p>
	        <p><input type="submit" value="Login" /></p>
		</FORM>
    </div>
  </div>
</body>
</html>
