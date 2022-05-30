package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReponsitory extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Id(int id);
}
