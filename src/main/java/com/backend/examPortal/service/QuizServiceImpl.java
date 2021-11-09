package com.backend.examPortal.service;

import com.backend.examPortal.Repo.CategoryRepo;
import com.backend.examPortal.Repo.QuizRepo;
import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.entity.quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    CategoryRepo catRepo;
    @Override
    public Quiz createQuiz(Quiz q) {
        Quiz created = quizRepo.save(q);
        System.out.println(created);
        return created;
    }

    @Override
    public List<Quiz> getQuizByCategory(String category) {
        Category cat = catRepo.findByCategory(category);
        return quizRepo.findByCategory(cat);
    }

    @Override
    public List<Quiz> getQuizByTopic(String topic) {
        return quizRepo.findByTopic(topic);
    }

    @Override
    public Quiz getQuizById(int id) {
        return quizRepo.findById(id);
    }
}
