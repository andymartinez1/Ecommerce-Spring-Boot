package com.andymartinez1.ecomm.service;

import com.andymartinez1.ecomm.dto.ProductDTO;
import com.andymartinez1.ecomm.entity.Product;
import com.andymartinez1.ecomm.exception.ProductNotFoundException;
import com.andymartinez1.ecomm.mapper.ProductMapper;
import com.andymartinez1.ecomm.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductMapper::mapToProductDTO)
                .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
