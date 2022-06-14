package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitoy extends JpaRepository<Category, Integer> {
}
