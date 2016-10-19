package action;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Author;

public class AuthorDAO {//有关author的数据库操作类
	public List<Author> selectAuthor(String name){
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Author> authorList=new ArrayList<Author>();
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
			String sql="select * from author where name='"+name+"'";
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				long authorID=rs.getLong("authorID");
				int age=rs.getInt("age");
				String country=rs.getString("country");

				Author temp=new Author(authorID,name,age,country);
				authorList.add(temp);
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
		return authorList;
	}
	public Author selectAuthor(long authorID){
		Author result=null;
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
			String sql="select * from author where authorID="+authorID;
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next()){
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String country=rs.getString("country");
				Author temp=new Author(authorID,name,age,country);
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
