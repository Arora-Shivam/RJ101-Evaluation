package com.tutorial.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.beans.Tutorial;
import com.tutorial.services.TutorialService;

@RestController
@RequestMapping("/api")
public class TutorialController {
	
	@Autowired
	private TutorialService tutorialService;
	
	@PostMapping("/tutorials")
	public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial){
		
		tutorialService.createTutorial(tutorial);
	
		return new ResponseEntity<String>("Tutorial Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(){
		
		List<Tutorial> tutorials=tutorialService.findAllTutorial();
		return new ResponseEntity<List<Tutorial>>(tutorials,HttpStatus.FOUND);
	}
	
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathParam("id") int id){
		
		
		return null;
	}
	
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<String> updtaeTutorialById(@PathParam("id") int id){
		
		tutorialService.updateTutorial(id);
		
		return new ResponseEntity<String>("Tutorial Status Updated",HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<String> deleteTutorialById(@PathParam("id") int id){
		
		tutorialService.deleteTutorial(id);
		
		return new ResponseEntity<String>("Tutorial Deleted",HttpStatus.CREATED);
	}
	
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> getAllPublishedTutorials(){
		
		List<Tutorial> tutorials=tutorialService.findPublishedTutorial();
		return new ResponseEntity<List<Tutorial>>(tutorials,HttpStatus.FOUND);
	}
	
//	@GetMapping("/tutorials")
//	public ResponseEntity<List<Tutorial>> getAllTutorialsBasedOnTitle(@RequestParam("title") String title){
//		
//		List<Tutorial> tutorials=tutorialService.findTutorialByTitle(title);
//		return new ResponseEntity<List<Tutorial>>(tutorials,HttpStatus.FOUND);
//	}
	
	
	
}
