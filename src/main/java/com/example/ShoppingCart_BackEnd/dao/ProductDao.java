package com.example.ShoppingCart_BackEnd.dao;

import com.example.ShoppingCart_BackEnd.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends CrudRepository<Product,Integer> {

    @Query(value = "SELECT `id`, `category`, `description`, `image`, `pname`, `price` FROM `products` WHERE `pname` LIKE %:pname%",nativeQuery = true)
    List<Product> SearchProduct(@Param("pname") String pname);
}
