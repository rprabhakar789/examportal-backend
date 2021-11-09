package com.backend.examPortal.Repo;
import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
    public Quiz findById(int id);
    public List<Quiz>findByTopic(String topic);
    public List<Quiz> findByCategory(Category category);
}
