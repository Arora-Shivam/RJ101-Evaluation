package com.masai;

public abstract class LibraryAbstractUser implements LibraryUser {

	private String name;
	private int age;
	private String bookBorrowed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getBooksBorrowed() {
		return bookBorrowed;
	}
	
	public void setBooksBorrowed(String bookBorrowed) {
		this.bookBorrowed = bookBorrowed;
	}
	
	
	
}
