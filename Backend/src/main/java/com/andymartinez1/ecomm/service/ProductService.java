package com.andymartinez1.ecomm.service;

import com.andymartinez1.ecomm.dto.ProductDTO;
import com.andymartinez1.ecomm.exception.ProductNotFoundException;
import com.andymartinez1.ecomm.entity.Product;
import com.andymartinez1.ecomm.mapper.ProductMapper;
import com.andymartinez1.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product " + id + " not found"));
        return ProductMapper.mapToProductDTO(product);
    }
}
