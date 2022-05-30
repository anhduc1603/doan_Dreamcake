package com.anhduc.managecake.service;

import com.anhduc.managecake.model.Category;
import com.anhduc.managecake.reponsitory.CategoryReponsitoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryReponsitoy categoryReponsitoy;

    public List<Category> getAllCategory(){return categoryReponsitoy.findAll();}

    public void addCategory(Category category){
        categoryReponsitoy.save(category);
    }

    public void deleteCategoryById(int id){categoryReponsitoy.deleteById(id);}

    public Optional<Category> getCategoryById(int id){return categoryReponsitoy.findById(id);}
}
