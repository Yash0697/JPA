package com.author.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.author.bean.Book2;
import com.author.dao.AuthorCrudLab2;

public class AuthorControllerLab2 {

	public static void main(String... args){
		long id;
		String authorName;
		List<Book2> books;
		AuthorCrudLab2 authCrud = new AuthorCrudLab2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\t\t1.Retrive All Books.\t2.Query All Books Witten by Author\n\t\t3.List books in range 500 to 1000\t4.List Author Name using book ID\n");
		System.out.print("\t\t Enter your choice : ");
		int choice;
		try {
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1: books = authCrud.getAllBooks();
					for(Book2 book:books)
					{
						System.out.println("\n\t\tBook Title : "+book.getTitle());
					}
					break;
			case 2 : System.out.println("\t\tEnter author name : ");
					authorName = br.readLine();
					books = authCrud.getBooksByAuthor(authorName);
					for(Book2 book:books){
						System.out.println("\t\tBook ISBN : "+book.getIsbn());
						System.out.println("\t\tBook Name : "+book.getTitle());
						System.out.println("\t\tBook Price : "+book.getPrice());
					}
					break;
			case 3 : books = authCrud.getBooksInRange();
					if(books.size() > 0){
					for(Book2 book:books)
					{
						System.out.println("\t\tBook ISBN : "+ book.getIsbn() + ", Book Title : "+book.getTitle() + ", Book Price : " + book.getPrice());
					}
					}
					else
						System.out.println("\t\tNo Book in this price range");
					break;
			case 4 : System.out.print("\t\tEnter Book Id : ");
					 id = Long.parseLong(br.readLine());
					 String authName = authCrud.getAuthorByBookId(id);
					 if(authName != null)
						 System.out.println("\t\tAuthor Name : "+authName);
					 else
						 System.out.println("\t\tThis Book doesn't exist");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
