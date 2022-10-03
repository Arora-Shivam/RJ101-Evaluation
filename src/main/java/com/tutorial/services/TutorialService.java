package com.tutorial.services;

import java.util.List;

import com.tutorial.beans.Tutorial;

public interface TutorialService {

	
	public boolean createTutorial(Tutorial tutorial);
	
	public Tutorial findTutorialById(Integer id);
	
	public List<Tutorial> findAllTutorial();
	
	public List<Tutorial> findPublishedTutorial();
	
	public List<Tutorial> findTutorialByTitle(String title);
	
	public boolean deleteTutorial(Integer Id);
	
	public boolean updateTutorial(int id);
}
