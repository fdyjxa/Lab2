<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.BookDAO,entity.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除书目</title>
</head>
<body>
	<% 
	   	long isbn=Long.parseLong(request.getParameter("isbn").trim());
      	BookDAO dao=new BookDAO();
	   	int i=dao.deleteBook(isbn);
	   	if(i==1){
	   %>
	   <h5>删除成功</h5>
	   <%}
	   	else{
	   	%>
	   <h5>删除失败</h5>
	   <%} %>
	   <a href="HomePage.jsp">返回</a>
</body>
</html>