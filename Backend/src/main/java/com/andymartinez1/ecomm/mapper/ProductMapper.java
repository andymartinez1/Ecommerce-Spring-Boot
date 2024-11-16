package com.andymartinez1.ecomm.mapper;

import com.andymartinez1.ecomm.dto.ProductDTO;
import com.andymartinez1.ecomm.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getCategory(),
                product.getReleaseDate(),
                product.isProductAvailable(),
                product.getStockQuantity(),
                product.getImageName(),
                product.getImageType(),
                product.getImageData()
        );
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getBrand(),
                productDTO.getPrice(),
                productDTO.getCategory(),
                productDTO.getReleaseDate(),
                productDTO.isProductAvailable(),
                productDTO.getStockQuantity(),
                productDTO.getImageName(),
                productDTO.getImageType(),
                productDTO.getImageData()
        );
    }

}
