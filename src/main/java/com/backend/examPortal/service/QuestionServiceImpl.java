package com.backend.examPortal.service;

import com.backend.examPortal.Repo.QuestionRepo;
import com.backend.examPortal.Repo.QuizRepo;
import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements  QuestionService{

    @Autowired
    QuestionRepo quesRepo;

    @Autowired
    QuizRepo quizRepo;


    @Override
    public Question addQuestion(Question q) {
        return this.quesRepo.save(q);
    }

    @Override
    public Question updateQuestion(Question q) {
        return this.quesRepo.save(q);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<Question>(this.quesRepo.findAll());
    }

    @Override
    public Question getQuestion(int qId) {
        System.out.println(qId);
        return this.quesRepo.findById(qId);
    }

    @Override
    public List<Question> getQuestionByQuizId(int quizId) {
        Quiz quiz = quizRepo.findById(quizId);
        return this.quesRepo.findByQuiz(quiz);
    }
}
