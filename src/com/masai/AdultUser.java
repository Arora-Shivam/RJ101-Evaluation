package com.masai;

import java.util.Scanner;

public class AdultUser extends LibraryAbstractUser{

	@Override
	public void registerAccount() {
		// TODO Auto-generated method stub
		if(getAge()>12) {
			System.out.println("You have successfully registered under a Adult Account");
		}
		else 
			System.out.println("Sorry, Age must be greater than 12 to register as an adult");
		
	}

	@Override
	public void requestBook() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter the Book Category You want to borrow ");
		System.out.println("Enter Fiction or Kids");
		
		
		String bookName=input.nextLine();
		
		
		if(bookName.equalsIgnoreCase("Kids") || bookName.equalsIgnoreCase("Fiction")) {
			setBooksBorrowed(bookName);
		
		}
		
		
		while(!bookName.equalsIgnoreCase("Fiction") && !bookName.equalsIgnoreCase("Kids") ) {
			System.out.println("Enter a valid category");
			bookName=input.nextLine();
			
		}
			setBooksBorrowed(bookName);
		
		
		if(getBooksBorrowed().equalsIgnoreCase("Fiction")) {
			System.out.println("Book Issued successfully, please return the book within 7 days");
		}
		else
			System.out.println("Oops, you are allowed to take only adult fiction books");
	}

}
