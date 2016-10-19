<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.*,entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者查询</title>
</head>
<body>
	<% 
		AuthorDAO adao=new AuthorDAO();
		String authorName=request.getParameter("authorName");
		List<Author> authorList = adao.selectAuthor(authorName);
		if (authorList.isEmpty()){
			%><h5>查询不到作者信息！</h5><%
		}
		for(Author a:authorList){
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
		<table border="1">
	      <tr>
	          <td>ISBN</td>
	          <td>书名</td>
	          <td>出版商</td>
	          <td>出版日期</td>
	          <td>价格</td>
	      </tr>
	        <%
	           BookDAO bdao=new BookDAO();
	           List<Book> bookList =bdao.selectBook(a.getAuthorID());
	           if(bookList.isEmpty()){
	        	   %><h5>查询不到该作者图书信息！</h5><%
	           }
	           for(Book b:bookList)
	           {%>
	          <tr>
	              <td><%=b.getISBN() %></td>
	              <td><%=b.getTitle() %></td>
	              <td><%=b.getPublisher() %></td>
	              <td><%=b.getPublishDate() %></td>
	              <td><%=b.getPrice() %></td>
	          </tr>
	            <%}
			}
	       %>
  		</table>
  	<a href="HomePage.jsp">返回</a>
</body>
</html>