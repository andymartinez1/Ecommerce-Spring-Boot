package com.andymartinez1.ecomm.service;

import com.andymartinez1.ecomm.exception.ProductNotFoundException;
import com.andymartinez1.ecomm.model.Product;
import com.andymartinez1.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product " + id + "not found"));
    }
}
