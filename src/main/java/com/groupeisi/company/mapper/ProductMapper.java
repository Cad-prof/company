package com.groupeisi.company.mapper;

import com.groupeisi.company.dto.ProductDTO;
import com.groupeisi.company.entities.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product p) {
        return new ProductDTO(p.getId(), p.getRef(), p.getName(), p.getStock());
    }
    public static Product toEntity(ProductDTO dto) {
        return new Product(dto.getRef(), dto.getName(), dto.getStock());
    }
}