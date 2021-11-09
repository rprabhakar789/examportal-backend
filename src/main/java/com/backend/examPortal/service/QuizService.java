package com.backend.examPortal.service;

import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.entity.quiz.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz createQuiz(Quiz q);
    public List<Quiz> getQuizByCategory(String category);
    public List<Quiz> getQuizByTopic(String topic);
    public Quiz getQuizById(int id);

}
