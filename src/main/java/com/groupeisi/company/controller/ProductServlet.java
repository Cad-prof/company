package com.groupeisi.company.controller;

import com.groupeisi.company.dto.ProductDTO;
import com.groupeisi.company.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Loading product list");
        List<ProductDTO> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ref = req.getParameter("ref");
        String name = req.getParameter("name");
        double stock = Double.parseDouble(req.getParameter("stock"));

        ProductDTO dto = new ProductDTO(null, ref, name, stock);
        productService.addProduct(dto);
        logger.info("Product added: {}", ref);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}