package com.groupeisi.company.service;

import com.groupeisi.company.dao.ProductDAO;
import com.groupeisi.company.dto.ProductDTO;
import com.groupeisi.company.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductDAO productDAO;

    public ProductService() { this.productDAO = new ProductDAO(); }
    public ProductService(ProductDAO dao) { this.productDAO = dao; } // for testing

    public void addProduct(ProductDTO dto) {
        logger.info("Adding product: {}", dto.getRef());
        productDAO.save(ProductMapper.toEntity(dto));
    }

    public List<ProductDTO> getAllProducts() {
        logger.info("Fetching all products");
        return productDAO.findAll().stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}