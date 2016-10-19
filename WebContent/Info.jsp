<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="action.*,entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本书及作者详细信息</title>
</head>
<body>
	<% 
		BookDAO bdao=new BookDAO();
		long isbn=Long.parseLong(request.getParameter("isbn").trim());
		Book b=bdao.getBookInfo(isbn);
		if(b==null){
	%>
		<h5>查询不到图书信息！</h5>
	<%}
		else{
	%>
	<table border="1">
		<tr>
          <td>ISBN</td>
          <td>书名</td>
          <td>作者编号</td>
          <td>出版商</td>
          <td>出版日期</td>
          <td>价格</td>
      	</tr>
      	<tr>
          <td><%= isbn %></td>
          <td><%= b.getTitle() %></td>
          <td><%= b.getAuthorID() %></td>
          <td><%= b.getPublisher() %></td>
          <td><%= b.getPublishDate() %></td>
          <td><%= b.getPrice() %></td>
      	</tr>
	</table>
	<%}
		AuthorDAO adao=new AuthorDAO();
		String temp=request.getParameter("authorID").trim();
		long authorID=Long.parseLong(temp);
		Author a=adao.selectAuthor(authorID);
		if(a==null){
	%>
		<h5>查询不到作者信息！</h5>
	<%}
		else{
	%>
		<table border="1">
		<tr>

          <td>作者编号</td>
          <td>姓名</td>
          <td>年龄</td>
          <td>国籍</td>
      	</tr>
      	<tr>
          <td><%= a.getAuthorID() %></td>
          <td><%= a.getName() %></td>
          <td><%= a.getAge() %></td>
          <td><%= a.getCountry() %></td>
      	</tr>
	</table>
	<%} %>
	<a href="HomePage.jsp">返回</a>
</body>
</html>