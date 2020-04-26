package com.author.dao;

import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.author.bean.Author1;



public class AuthorCrudLab1 {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("AuthorJPA");
	static EntityManager entityManager= emfactory.createEntityManager();
	/*public static void main(String[] args) {
		BigInteger phoneNo = new BigInteger("9909899889");
		AuthorCrud ac = new AuthorCrud();
		ac.insertData(new Author1(123, "Rakesh", "Omprakash", "Mehra", phoneNo));
		ac.insertData(new Author1(124, "Sanjay", "Leela", "Bhansali", phoneNo));
		BigInteger updatedPhone = new BigInteger("9909899888");
		ac.updateAuthor(123, updatedPhone);
		Author1 auth = ac.getAuthorDetails(123);
		System.out.println("Auther's Id : "+auth.getAuthorId());
		System.out.println("Name of Author : "+auth.getFirstName()+" "+auth.getMiddletName()+" "+auth.getLastName());
		System.out.println("Author's Phone Number : "+auth.getPhoneNo());
		ac.deleteAuthor(124);
		ac.insertData(new Author1(124, "Sanjay", "Leela", "Bhansali", phoneNo));
	}*/
	
	public void insertData(Author1 author) {	
			entityManager.getTransaction().begin();
			entityManager.persist(author);
			entityManager.getTransaction().commit();
			
	}
	
	public void updateAuthor(int authorId, BigInteger phoneNo) {
			entityManager.getTransaction().begin();
			Author1 author = entityManager.find(Author1.class, authorId);
			author.setPhoneNo(phoneNo);
			entityManager.getTransaction().commit();
			
	}
	
	public void deleteAuthor(int authorId) {
			entityManager.getTransaction().begin();
			Author1 author= entityManager.find(Author1.class,authorId);
			entityManager.remove(author);	
			entityManager.getTransaction().commit();
	}
		
	public Author1 getAuthorDetails(int authorId){
			Author1 author = entityManager.find(Author1.class, authorId);
			return author;
		}

}
