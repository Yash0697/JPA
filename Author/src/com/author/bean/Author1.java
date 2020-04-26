package com.author.bean;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table
public class Author1 implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private int authorId;
	private String firstName;
	private String middletName;
	private String lastName;
	private BigInteger phoneNo;
	
	public Author1()
	{
		super();
	}
	
	
	public Author1(int authorId, String firstName, String middletName, String lastName, BigInteger phoneNo) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.middletName = middletName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddletName() {
		return middletName;
	}
	public void setMiddletName(String middletName) {
		this.middletName = middletName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigInteger getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(BigInteger phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
