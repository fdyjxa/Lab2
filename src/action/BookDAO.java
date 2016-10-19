package action;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Book;

public class BookDAO {
	public List<Book> readBookDB(){
		List<Book> bookList=new ArrayList<Book>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));

		try {
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection(dbUrl,username,password);
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB","root","856142");
			String sql="select * from book";
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				long isbn=rs.getLong("isbn");
				String title=rs.getString("title");
				long authorID=rs.getInt("authorID");
				String publisher=rs.getString("publisher");
				Date publishDate=rs.getDate("publishDate");
				float price=rs.getFloat("price");
				Book temp=new Book(isbn,title,authorID,publisher,publishDate,price);
				bookList.add(temp);
			} 
		} catch (SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null)
						rs.close();
					if(psmt!=null)
						psmt.close();
					if(con!=null)
						con.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		return bookList;
	}
	
	public int deleteBook(long isbn){
		Connection con=null;
		PreparedStatement psmt=null;
		//ResultSet rs=null;
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));

		int result=0;
		try {
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection(dbUrl, username, password);
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB","root","856142");
			String sql="delete from book where isbn="+isbn;
			psmt=con.prepareStatement(sql);
			result=psmt.executeUpdate();
			psmt.close();
			con.close();
			
		} catch (SQLException e){
				e.printStackTrace();
			}
		return result;
	}
	
	public List<Book> selectBook(long authorID){
		List<Book> bookList=new ArrayList<Book>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));

		try {
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection(dbUrl, username, password);
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB","root","856142");
			String sql="select * from book where authorID="+authorID;
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				long isbn=rs.getLong("isbn");
				String title=rs.getString("title");
				String publisher=rs.getString("publisher");
				Date publishDate=rs.getDate("publishDate");
				float price=rs.getFloat("price");
				Book temp=new Book(isbn,title,authorID,publisher,publishDate,price);
				bookList.add(temp);
			} 
		} catch (SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null)
						rs.close();
					if(psmt!=null)
						psmt.close();
					if(con!=null)
						con.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		return bookList;
	}
	
	public Book getBookInfo(long isbn){
		Book result=null;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String username = System.getenv("ACCESSKEY");
		String password = System.getenv("SECRETKEY");
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		try{
			con=DriverManager.getConnection(dbUrl, username, password);
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB","root","856142");
			String sql="select * from book where isbn="+isbn;
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				String title=rs.getString("title");
				long authorID=rs.getLong("authorID");
				String publisher=rs.getString("publisher");
				Date publishDate=rs.getDate("publishDate");
				float price=rs.getFloat("price");
				Book temp=new Book(isbn,title,authorID,publisher,publishDate,price);
				result=temp;
			} 
		} catch (SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(rs!=null)
						rs.close();
					if(psmt!=null)
						psmt.close();
					if(con!=null)
						con.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		return result;
	}
}
