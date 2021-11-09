package com.backend.examPortal.service;

import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.entity.quiz.Quiz;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category c);
    public Category getCategoryByCategoryName(String category);

    Category getCategoryById(int id);

    List<Category> getAllCategories();
}
