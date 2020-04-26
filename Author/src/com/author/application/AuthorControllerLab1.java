package com.author.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

import com.author.bean.Author1;
import com.author.dao.AuthorCrudLab1;

public class AuthorControllerLab1 {

	public static void main(String[] args) {
		int id;
		Author1 auth;
		BigInteger phoneNumber;
		AuthorCrudLab1 authCrud = new AuthorCrudLab1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		System.out.print("\t\t1.Retrive using Author Id.\t2.Update PhoneNo. using Author Id\n\t\t3.Insert\t4.Delete using ID");
		System.out.println(": Enter your choice");
		int choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1: System.out.print("\t\tEnter Author Id to retrive details:");
				id = Integer.parseInt(br.readLine());
			    auth = authCrud.getAuthorDetails(id);
			    if(auth != null){
			    System.out.println("\t\tAuthor Name : "+auth.getFirstName() + " "+auth.getMiddletName() + " "+auth.getLastName());
			    System.out.println("\t\tAuthor PhoneNo. : "+auth.getPhoneNo());
			    }
			    else
			    	System.out.println("\t\tThe id you entered does not exixt.");
			    break;
		case 2 : System.out.print("\t\tEnter Author Id to retrive details:");
				 id = Integer.parseInt(br.readLine());
				 auth = authCrud.getAuthorDetails(id);
				    if(auth != null){
				    	System.out.println("\t\tEnter New Phone Number :");
				    	phoneNumber = new BigInteger(br.readLine());
				    	authCrud.updateAuthor(id, phoneNumber);
				    }
				    else
				    	System.out.println("\t\tThe id you entered does not exixt.");
				    break;
		case 3 : auth = new Author1();
				System.out.println("\t\tEnter new Author details in order id, first name, middle name, last name, phone number");
				id = Integer.parseInt(br.readLine());
				Author1 auth1 = authCrud.getAuthorDetails(id);
				if(auth1 == null){
				auth.setAuthorId(id);
				auth.setFirstName(br.readLine());
				auth.setMiddletName(br.readLine());
				auth.setLastName(br.readLine());
				auth.setPhoneNo(new BigInteger(br.readLine()));
				authCrud.insertData(auth);
				System.out.println(auth.getAuthorId()+" inserted");
				}
				else
					System.out.println("\t\tThis Author Already Exists");
				break;
				
		case 4 : System.out.print("\t\tEnter Author Id to retrive details:");
					id = Integer.parseInt(br.readLine());
				    auth = authCrud.getAuthorDetails(id);
				    if(auth != null){
				    	authCrud.deleteAuthor(id);
						System.out.println(auth.getAuthorId()+" deleted");
				    }
				    else
				    	System.out.println("\t\tThis Author doesn't exist");
				    break;
		default :
			System.out.println("Enter Correct choice among 1-4");
		}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
