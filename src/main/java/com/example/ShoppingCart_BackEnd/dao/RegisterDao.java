package com.example.ShoppingCart_BackEnd.dao;

import com.example.ShoppingCart_BackEnd.model.UserRegister;
import org.springframework.data.repository.CrudRepository;

public interface RegisterDao extends CrudRepository<UserRegister,Integer> {
}
