package com.ohgiraffers.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ProductDTO {

    private int product_code;
    private String product_name;
    private int category_code;
    private int product_quantity;
    private String product_detail;
}
