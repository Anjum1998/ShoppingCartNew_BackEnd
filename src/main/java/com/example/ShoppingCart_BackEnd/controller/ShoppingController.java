package com.example.ShoppingCart_BackEnd.controller;

import com.example.ShoppingCart_BackEnd.dao.ProductDao;
import com.example.ShoppingCart_BackEnd.dao.RegisterDao;
import com.example.ShoppingCart_BackEnd.model.Product;
import com.example.ShoppingCart_BackEnd.model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingController {
    @Autowired
    private ProductDao dao;

    @Autowired
    private RegisterDao d;

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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Product> SearchProduct(@RequestBody Product p)
    {
        String pname=p.getPname().toString();
        System.out.println(pname);
        return (List<Product>) dao.SearchProduct(p.getPname());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/register",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegister(@RequestBody UserRegister u)
    {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirm().toString());
        d.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<UserRegister> UserLogin(@RequestBody UserRegister u)
    {
        String email=u.getEmail().toString();
        String password=u.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        return (List<UserRegister>) d.UserLogin(u.getEmail(),u.getPassword());
    }
}
