package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReponsitoy extends JpaRepository<Category, Integer> {
}
