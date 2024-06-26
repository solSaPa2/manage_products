package com.ohgiraffers.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CategoryProductDTO {

    private int categoryCode;
    private String categoryName;

    private List<ProductDTO> proList;
}
