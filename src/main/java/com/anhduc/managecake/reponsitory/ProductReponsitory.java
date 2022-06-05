package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductReponsitory extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Id(int id);


    @Query( value = "SELECT  * FROM product p WHERE p.name LIKE %?1%",nativeQuery = true)
    List<Product> findByName(String name);
}
