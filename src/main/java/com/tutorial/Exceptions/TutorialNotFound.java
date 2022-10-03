package com.tutorial.Exceptions;

public class TutorialNotFound extends RuntimeException{

	public TutorialNotFound() {
		
	}
	
	public TutorialNotFound(String msg) {
		super(msg);
	}
	
	
}
