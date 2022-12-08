package com.example.ShoppingCart_BackEnd.dao;

import com.example.ShoppingCart_BackEnd.model.UserRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterDao extends CrudRepository<UserRegister,Integer> {
    @Query(value = "SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone` FROM `user_register` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<UserRegister> UserLogin(@Param("email") String email ,@Param("password") String password);
}
