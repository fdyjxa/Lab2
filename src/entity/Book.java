package entity;
import java.sql.Date;
//import com.opensymphony.xwork2.ActionSupport;

public class Book{
	private long isbn;
	private String title;
	private long authorID;
	private String publisher;
	private Date publishDate;
	private float price;
	
	public long getISBN(){
		return isbn;
	}
	public void setISBN(long isbn){
		this.isbn=isbn;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public long getAuthorID(){
		return authorID;
	}
	public void setAuthorID(long authorID){
		this.authorID=authorID;
	}
	public String getPublisher(){
		return publisher;
	}
	public void setPublisher(String publisher){
		this.publisher=publisher;
	}
	public Date getPublishDate(){
		return publishDate;
	}
	public void setPublishDate(Date publishDate){
		this.publishDate=publishDate;
	}
	public float getPrice(){
		return price;
	}
	public void setPrice(float price){
		this.price=price;
	}
	public Book(long isbn,String title,long authorID,String publisher,Date publishDate,float price){
		this.isbn=isbn;
		this.title=title;
		this.authorID=authorID;
		this.publisher=publisher;
		this.publishDate=publishDate;
		this.price=price;
	}
}
