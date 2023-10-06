package com.example.productApp.controller;

import com.example.productApp.model.ProductBean;
import com.example.productApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService ps;
    @PostMapping("/add")
    public ResponseEntity<ProductBean> saveProduct(@RequestBody ProductBean product) throws Exception{
        ProductBean saved = this.ps.addProduct(product);
        return new ResponseEntity<ProductBean>(saved, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    private List<ProductBean> getProducts(){return ps.getAllProducts();}

    @GetMapping("/get/{id}")
    private Optional<ProductBean> getProduct(@PathVariable int id){
//        Optional<ProductBean> op = ps.getProduct(id);
        return ps.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProduct(@PathVariable int id){ps.delete(id);}
    @PutMapping("/edit/{id}")
    private String editProduct(@PathVariable int id,@RequestBody ProductBean p){
        return ps.updateProduct(id,p);
    }
}
