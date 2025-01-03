package com.andymartinez1.ecomm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private String category;

    private Date releaseDate;

    private boolean productAvailable;

    private int stockQuantity;

    private String imageName;
    private String imageType;
    private byte[] imageData;

}
