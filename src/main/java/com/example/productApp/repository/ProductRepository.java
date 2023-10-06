package com.example.productApp.repository;

import com.example.productApp.model.ProductBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer> {

}
