package entity;

public class Author {
	private long authorID;
	private String name;
	private int age;
	private String country;
	
	public long getAuthorID(){
		return authorID;
	}
	public void setAuthorID(long authorID){
		this.authorID=authorID;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public String getCountry(){
		return country;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public Author(long authorID, String name, int age, String country){
		this.authorID=authorID;
		this.name=name;
		this.age=age;
		this.country=country;
	}
}
