package com.andymartinez1.ecomm.service;

import com.andymartinez1.ecomm.dto.ProductDTO;
import com.andymartinez1.ecomm.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException;

    void deleteProduct(Long id);

    List<ProductDTO> searchProducts(String keyword);
}
