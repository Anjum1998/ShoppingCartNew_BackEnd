package com.example.ShoppingCart_BackEnd.controller;

import com.example.ShoppingCart_BackEnd.dao.ProductDao;
import com.example.ShoppingCart_BackEnd.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @CrossOrigin("*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String AddProduct(@RequestBody Product p)
    {
        System.out.println(p.getPname().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getPrice());
        System.out.println(p.getDescription().toString());
        dao.save(p);
        return "product added";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Product> ViewProduct()
    {
        return (List<Product>) dao.findAll();
    }
}
