package com.metacube.REST1;

import javax.xml.bind.annotation.XmlRootElement;


/**POJO class to represent book in database
 * @author Rahul
 *
 */
@XmlRootElement
public class Book 
{

private int bookId;
private String title;
private String writer;
private String publisher;
private int publishedYear;


// getter and setters

public void setBookId(int bookId) {
	this.bookId = bookId;
}
public void setTitle(String title) {
	this.title = title;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public void setPublishedYear(int publishedYear) {
	this.publishedYear = publishedYear;
}
public int getBookId() {
	return bookId;
}
public String getTitle() {
	return title;
}
public String getWriter() {
	return writer;
}
public String getPublisher() {
	return publisher;
}
public int getPublishedYear() {
	return publishedYear;
}

@Override
public String toString() {
	return "Book [bookId=" + bookId + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
			+ ", publishedYear=" + publishedYear + "]";
}

}
