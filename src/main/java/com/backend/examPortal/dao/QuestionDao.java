package com.backend.examPortal.dao;

import java.util.List;

import com.backend.examPortal.entity.quiz.Question;

public interface QuestionDao {
	public List<Question>findAll();
}
