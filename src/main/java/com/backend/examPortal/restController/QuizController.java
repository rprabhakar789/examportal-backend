package com.backend.examPortal.restController;

import java.util.List;

import com.backend.examPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.examPortal.dao.QuestionDao;
import com.backend.examPortal.dao.QuizDao;
import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class QuizController {
	
	QuizDao quizDao;
	QuestionDao questionDao;
	QuizService quizService;

	@Autowired
	public QuizController(QuizDao qDao, QuestionDao quesDao,QuizService q)
	{
		quizDao = qDao;
		questionDao = quesDao;
		quizService = q;
	}
	
	@RequestMapping("/getQuiz")
	public List<Quiz> getQuiz(){
		return quizDao.findAll();
	}
	@RequestMapping("/getQuestions")
	public List<Question> getQuestion(){
		return questionDao.findAll();
	}

	@RequestMapping("/addQuiz")
	public Quiz addQuiz(@RequestBody Quiz quiz)throws Exception{
		return quizService.createQuiz(quiz);
	}

	@RequestMapping("/getQuiz/{topic}")
	public List<Quiz>getQuizByTopic(@PathVariable String topic)
	{
		return quizService.getQuizByTopic(topic);
	}

	@RequestMapping("/getQuizByCategory/{category}")
	public List<Quiz>getQuizByCategory(@PathVariable String category)
	{
		return quizService.getQuizByCategory(category);
	}

}
