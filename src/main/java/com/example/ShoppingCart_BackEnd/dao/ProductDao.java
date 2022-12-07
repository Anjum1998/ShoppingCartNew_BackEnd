package com.example.ShoppingCart_BackEnd.dao;

import com.example.ShoppingCart_BackEnd.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}
