<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<%
	session.setAttribute("status", null);
	String name = (String)session.getAttribute("name");
	String login = request.getRequestURI();
	session.setAttribute("login_uri", login);
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>課題04/20</title>
</head>
<body>
  <div id="wrapper">
  	<div id ="header">
  		<c:choose>
			<c:when test="${name!=null}">
				<DIV id="name">
					<%
						String username = (String)session.getAttribute("user_name");
						out.print("<P>ようこそ"+username+"様</P>");
					%>
				</DIV>
			</c:when>
		</c:choose>
  	</div>
    <div id="main">
      <a href="login.jsp">ログイン</a>
      <form action="../CategoryServlet" method="get">
      	<input type="submit" value="商品一覧">
      </form>
      <a href="logout.jsp">ログアウト</a>
    </div>
  </div>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題04/20</title>
</head>
<body>

</body>
</html> --%>
