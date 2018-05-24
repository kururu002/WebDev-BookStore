<%@ page import="model.Book" %>
<%@ page import="java.sql.Date" %>

<%
// title, author, price, publisher, date, type, intro
Object bookObject = request.getAttribute("book");
String img=(String)request.getAttribute("IMG");
Book book;
String title="", author="", publisher="",IMG="";
Date date=null;
int price=0,stock=0;
if (bookObject!=null) {
	book = (Book)bookObject;
	
	title = book.getTitle();
	author = book.getAuthor();
	publisher = book.getPublisher();
	date = book.getDate();	
	stock=book.getStock();
	IMG=img;
}
%>
{
"Title":"<%=title %>",
"Author":"<%=author %>",
"Publisher":"<%=publisher %>",
"Date":"<%=date %>",
"Stock":"<%=stock %>"
"IMG":"<%=IMG %>"
}