<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="action.BookDAO,entity.Book" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>欢迎!</title>    
</head>
  
  <body>
  	<h5>请输入要查询的作者名字</h5>
  	<form name="authorName" action="Search.jsp" method="post">
  		<input type="text" name="authorName" maxlength="100">
  		<input type="submit" value="查询">
  	</form>
    <table border="1">
      <tr>
          <!-- <td>isbn</td>
          <td>title</td>
          <td>authorID</td>
          <td>publisher</td>
          <td>publishDate</td>
          <td>price</td> -->
          <td>书名</td>
          <td>删除</td>
      </tr>
        <%
           BookDAO dao=new BookDAO();
           List<Book> bookList =dao.readBookDB();
           for(Book b:bookList)
           {%>
          <tr>
              <td><a href="Info.jsp?isbn=<%= b.getISBN() %>&authorID=<%= b.getAuthorID() %>"><%=b.getTitle() %></a></td>
              
              <!-- <td><%=b.getAuthorID() %></td>
              <td><%=b.getPublisher() %></td>
              <td><%=b.getPublishDate() %></td>
              <td><%=b.getPrice() %></td> -->
              <td><a href="Delete.jsp?isbn=<%= b.getISBN() %>">删除</a></td>
          </tr>
            <%}
       %>
  </table>
    
  </body>
</html>