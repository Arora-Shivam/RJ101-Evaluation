package com.masai;

import java.util.Scanner;

public interface LibraryInterfaceDemo {

	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Masai library");
		
		System.out.println("To Register your Account enter the following details");
		
		
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name=input.nextLine();
		
		System.out.println("Enter your age");
		int age=input.nextInt();
		
		
		StratagyLibraryUser user=new StratagyLibraryUser(name, age);
		
		user.requestBook();
			
			
		
		
		
		
	}
}
