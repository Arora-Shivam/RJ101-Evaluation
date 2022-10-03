package com.masai;

public class StratagyLibraryUser {

	LibraryAbstractUser libUser;
	
	public StratagyLibraryUser(String name,int age) {
		
		
		
		if(age<=12) {
			libUser=new ChildUser();
			
		}
		else {
			libUser=new AdultUser();
		}
		libUser.setAge(age);
		libUser.setName(name);
		libUser.registerAccount();
	}
	
	public void requestBook() {
		
		libUser.requestBook();
	}
	
}
