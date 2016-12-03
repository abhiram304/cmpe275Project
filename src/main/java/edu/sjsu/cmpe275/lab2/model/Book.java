package edu.sjsu.cmpe275.lab2.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="BOOK")
public class Book implements Serializable{
	private static final long serialVersionUID = -9022929256211682745L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKID")
	private String bookid;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CALLNUM")
	private String callnum;
	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "YEAR")
	private String year;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "COPIES")
	private String copies;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "KEYWORDS")
	private String keywords;
	
	
	@ManyToOne(mappedBy ="books")
	private List<User> users;
	
	public Book(){
		super();
	}
	
	public Book(String bookid, String author, String title, String callnum, String publisher, String year, String location, String copies, String status, String keywords, List<User> users) {
		super();
		this.bookid = bookid;
		this.author = author;
		this.title = title;
		this.callnum = callnum;
		this.publisher = publisher;
		this.year = year;
		this.location = location;
		this.copies = copies;
		this.status = status;
		this.keywords = keywords;
		this.users = users;
	}
	

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

//	public String getPhoneId() {
//		return phoneId;
//	}
//
//	public void setPhoneId(String phoneId) {
//		this.phoneId = phoneId;
//	}
//
//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

//	@Override
//	public String toString() {
//		return "Phone [phoneId=" + phoneId + ", number=" + number + ", description=" + description + ", address="
//				+ address + ", users=" + users + "]";
//	}	
}
