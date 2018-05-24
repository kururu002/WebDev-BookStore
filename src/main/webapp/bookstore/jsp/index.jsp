<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BookStore</title>
</head>
<body>
	<%System.out.println((String) session.getAttribute("role"));
		if ((session.getAttribute("uid") == null)
				|| (session.getAttribute("uid") == "")) {
	%>
	You are not logged in
	<br/>
	<a href="login.jsp">Please Login<a> <%
 	} else if (
 	        ((String) session.getAttribute("role")).equals("admin")) {
 %>
			<%
				response.sendRedirect("allBooksPro");
			%> <%
 	} else {
 		 %> Welcome <%=session.getAttribute("uid") %>
			<% response.sendRedirect("UserCart");
			
	}
%>
</body>
</html>