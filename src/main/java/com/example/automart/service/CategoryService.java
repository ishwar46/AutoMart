package  com.example.automart.service;

import  com.example.automart.entity.Category;

import java.util.List;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
