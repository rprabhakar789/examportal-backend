package com.backend.examPortal.restController;

import com.backend.examPortal.entity.quiz.Category;
import com.backend.examPortal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/category")
public class CategoryController {

    CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category cat = this.categoryService.addCategory(category);
        return ResponseEntity.ok(cat);
    }
    @GetMapping("/{param}")
    public ResponseEntity<?> getCategory(@PathVariable int id){
        Category cat = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories(){
        List<Category> cats = this.categoryService.getAllCategories();
        return ResponseEntity.ok(cats);
    }

}
