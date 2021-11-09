package com.backend.examPortal.service;

import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question q);
    public Question updateQuestion(Question q);
    public Set<Question> getQuestions();
    public Question getQuestion(int qId);
    public List<Question> getQuestionByQuizId(int quizId);
}
