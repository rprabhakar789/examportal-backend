package com.backend.examPortal.Repo;

import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    public Question findById(int id);
    public List<Question> findByQuiz(Quiz quiz);
}
