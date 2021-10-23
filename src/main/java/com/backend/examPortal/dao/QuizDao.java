package com.backend.examPortal.dao;

import java.util.List;

import com.backend.examPortal.entity.quiz.Quiz;


public interface QuizDao {
	public List<Quiz>findAll();
	public void add(Quiz q);
	public Quiz getById(int id);
	public Quiz update(Quiz q);
	public void delete(Quiz q);
	
}
