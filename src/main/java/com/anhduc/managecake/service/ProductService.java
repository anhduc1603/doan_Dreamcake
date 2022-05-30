package com.anhduc.managecake.service;

import com.anhduc.managecake.model.Product;
import com.anhduc.managecake.reponsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductReponsitory productReponsitory;

    public List<Product> getAllProduct(){
        return productReponsitory.findAll();
    }
    public void addProduct(Product product){
        productReponsitory.save(product);
    }

    public void removeProductById(long id){
        productReponsitory.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productReponsitory.findById(id);
    }

    public List<Product> getAllProductCategoryId(int id){
        return productReponsitory.findAllByCategory_Id(id);
    }

}
