package com.example.ShoppingCart_BackEnd.controller;

import com.example.ShoppingCart_BackEnd.dao.ProductDao;
import com.example.ShoppingCart_BackEnd.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @CrossOrigin("*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddProduct(@RequestBody Product p)
    {
        System.out.println(p.getPname().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getPrice());
        System.out.println(p.getDescription().toString());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Product> ViewProduct()
    {
        return (List<Product>) dao.findAll();
    }
}
