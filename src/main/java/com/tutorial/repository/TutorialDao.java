package com.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.beans.Tutorial;

@Repository
public interface TutorialDao extends JpaRepository<Tutorial, Integer>{

	List<Tutorial> findAll();
}
