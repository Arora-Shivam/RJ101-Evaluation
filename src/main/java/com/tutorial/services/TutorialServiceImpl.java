package com.tutorial.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.Exceptions.TutorialNotFound;

import com.tutorial.beans.Tutorial;
import com.tutorial.repository.TutorialDao;

@Service
public class TutorialServiceImpl implements TutorialService{

	@Autowired
	TutorialDao tutorialDao;
	
	@Override
	public boolean createTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		
		tutorialDao.save(tutorial);
		return true;
	}

	@Override
	public Tutorial findTutorialById(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Tutorial> optTutorial=tutorialDao.findById(id);
		
		if(optTutorial.isPresent()) {
			return optTutorial.get();
		}
		else
			throw new TutorialNotFound("Tutorial With this Id does not Exist");
		
	}

	@Override
	public List<Tutorial> findAllTutorial() {
		// TODO Auto-generated method stub
		
		List<Tutorial> tutorials=tutorialDao.findAll();
		
		if(tutorials.size()!=0) {
			return tutorials;
		}
		else {
			throw new TutorialNotFound("No Tutorials Exist in Our DataBase");
		}
		
	}

	@Override
	public List<Tutorial> findPublishedTutorial() {
		// TODO Auto-generated method stub
		
		List<Tutorial> tutorials=findAllTutorial();
		
		Set<Tutorial> tutorialsSet=new HashSet<>();
		
		for(Tutorial t : tutorials) {
			if(t.getStatus().equalsIgnoreCase("PUBLISHED")) {
				tutorialsSet.add(t);
			}
		}
		
		if(tutorialsSet.size()!=0) {
			
			return new ArrayList<>(tutorialsSet);
		}
		else {
			throw new TutorialNotFound("No Published Tutorials Exist in Our DataBase");
		}
	}

	@Override
	public List<Tutorial> findTutorialByTitle(String title) {
		// TODO Auto-generated method stub
		
		List<Tutorial> tutorials=findAllTutorial();
		
		Set<Tutorial> tutorialsSet=new HashSet<>();
		
		for(Tutorial t : tutorials) {
			
			if(t.getTitle().contains(title)) {
				tutorialsSet.add(t);
			}
		}
		
		if(tutorialsSet.size()!=0) {
			
			return new ArrayList<>(tutorialsSet);
		}
		else {
			throw new TutorialNotFound("No Tutorials Exist in Our DataBase with title "+ title);
		}
	}

	@Override
	public boolean deleteTutorial(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Tutorial> optTutorial=tutorialDao.findById(id);
		
		if(optTutorial.isPresent()) {
			
			tutorialDao.deleteById(id);
			return true;
		}
		else
			throw new TutorialNotFound("Tutorial With this Id does not Exist");
	}

	@Override
	public boolean updateTutorial(int id) {
		// TODO Auto-generated method stub
		Optional<Tutorial> optTutorial=tutorialDao.findById(id);
		
		if(optTutorial.isPresent()) {
			
			Tutorial tutorial=optTutorial.get();
			
			tutorial.setStatus("PUBLISHED");
			
			tutorialDao.save(tutorial);
			
			return true;
		}
		else
			throw new TutorialNotFound("Tutorial With this Id does not Exist");
		
	}

}
