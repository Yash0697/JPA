package com.author.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name="bookauthor.findAuthorId", query="SELECT ba.author_id FROM BookAuthor2 ba  where ba.book_isbn=:book_id") 
public class BookAuthor2 {

	@Id
	private long book_isbn;
	private int author_id;
	public long getBook() {
		return book_isbn;
	}
	public void setBook(long book_isbn) {
		this.book_isbn = book_isbn;
	}
	public int getAuthor() {
		return author_id;
	}
	public void setAuthor(int author_id) {
		this.author_id = author_id;
	}
	
	
}
