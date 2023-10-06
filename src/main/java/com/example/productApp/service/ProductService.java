package com.example.productApp.service;

import com.example.productApp.model.ProductBean;
import com.example.productApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository pr;

    public ProductBean addProduct(ProductBean p){
        pr.save(p);
        return p;
    }

    public List<ProductBean> getAllProducts(){
        List<ProductBean> pro = new ArrayList<ProductBean>();
        pr.findAll().forEach(prod->pro.add(prod));
        return pro;
    }
    public void delete(int id){
        pr.deleteById(id);
    }
    public Optional<ProductBean> getProduct(int id){
        Optional<ProductBean> p = pr.findById(id);
        return p;
    }

    public String updateProduct(int id, ProductBean p) {
        Optional<ProductBean> pro = pr.findById(id);
        if(pro.isEmpty()){
            return "Product does not exist";
        }else {
            pro.get().setPrice(p.getPrice());
            pro.get().setCategory(p.getCategory());
            pro.get().setBrand(p.getBrand());

            pr.save(pro.get());

            return "Updated: "+pro;
        }
    }
}
