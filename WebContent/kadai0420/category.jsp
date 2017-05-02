<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page session="true" %>
<%
	ArrayList<ArrayList<String>> array = (ArrayList<ArrayList<String>>)session.getAttribute("product_array");
	String login = request.getRequestURI();
	session.setAttribute("login_uri", login);
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>商品一覧</title>
</head>
<body>
	<div id="wrapper">
		<% out.print(array.get(0)); %>
	</div>
</body>
</html>