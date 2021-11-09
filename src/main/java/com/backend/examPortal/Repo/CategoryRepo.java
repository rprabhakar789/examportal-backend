package com.backend.examPortal.Repo;

import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.entity.quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo  extends JpaRepository<Category,Integer> {
    public Category findByCategory(String category);
}
