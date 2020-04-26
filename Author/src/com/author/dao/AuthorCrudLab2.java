package com.author.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.author.bean.Author1;
import com.author.bean.Author2;
import com.author.bean.Book2;

public class AuthorCrudLab2 {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("AuthorJPA");
	static EntityManager entityManager= emfactory.createEntityManager();
	public Author1 getAuthorDetails(int authorId){
		Author1 author = entityManager.find(Author1.class, authorId);
		return author;
	}
	public List<Book2> getAllBooks(){
		Query bookQuery = entityManager.createNamedQuery("Book.findAll");
		List<Book2> books = bookQuery.getResultList();
		return books;
	}
	
	public List<Book2> getBooksByAuthor(String authorName)
	{
		int authId = (int) entityManager.createNamedQuery("author.id").setParameter("author_name", authorName).getSingleResult();
		long bookId = (long) entityManager.createQuery("select ba.book_isbn from BookAuthor2 ba where ba.author_id="+authId).getSingleResult();
		Query query = entityManager.createQuery("select b from Book2 b where b.isbn="+bookId);
		List<Book2> books = query.getResultList();
		return books;
	}
	
	public List<Book2> getBooksInRange(){
		 Query query = entityManager.createQuery( "Select b from Book2 b  where b.price Between 500 and 1000" );
	      
	      List<Book2> list=(List<Book2>)query.getResultList( );
	      return list;
	}
	public String getAuthorByBookId(long isbn){
		Query query = entityManager.createNamedQuery("bookauthor.findAuthorId").setParameter("book_id", isbn);
		int auth_id = (int) query.getSingleResult();
		Query query1 = entityManager.createQuery("select a.name from Author2 a where a.id="+auth_id);
		String authName = (String) query1.getResultList().get(0);
		return authName;
	}
}
