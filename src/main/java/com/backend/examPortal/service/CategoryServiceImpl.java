package com.backend.examPortal.service;

import com.backend.examPortal.Repo.CategoryRepo;
import com.backend.examPortal.entity.quiz.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    CategoryRepo catRepo;
    @Override
    public Category addCategory(Category c) {
        Category created = this.catRepo.save(c);
        return created;
    }

    @Override
    public Category getCategoryByCategoryName(String category) {
        return this.catRepo.findByCategory(category);
    }

    @Override
    public Category getCategoryById(int id) {
        return this.catRepo.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        System.out.println("finding all categories");
        return this.catRepo.findAll();
    }
}
