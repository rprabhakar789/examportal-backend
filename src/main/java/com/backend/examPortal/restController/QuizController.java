package com.backend.examPortal.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.examPortal.dao.QuestionDao;
import com.backend.examPortal.dao.QuizDao;
import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("/api")
public class QuizController {
	
	QuizDao quizDao;
	QuestionDao questionDao;
	@Autowired
	public QuizController(QuizDao qDao, QuestionDao quesDao)
	{
		quizDao = qDao;
		questionDao = quesDao;
	}
	
	@RequestMapping("/getQuiz")
	public List<Quiz> getQuiz(){
		return quizDao.findAll();
	}
	@RequestMapping("/getQuestions")
	public List<Question> getQuestion(){
		return questionDao.findAll();
	}
	
}
