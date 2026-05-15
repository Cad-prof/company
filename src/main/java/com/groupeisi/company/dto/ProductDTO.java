package com.groupeisi.company.dto;

public class ProductDTO {
    private Long id;
    private String ref;
    private String name;
    private double stock;

    public ProductDTO() {}
    public ProductDTO(Long id, String ref, String name, double stock) {
        this.id = id; this.ref = ref; this.name = name; this.stock = stock;
    }
    // Getters & Setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getRef() { return ref; } public void setRef(String ref) { this.ref = ref; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public double getStock() { return stock; } public void setStock(double stock) { this.stock = stock; }
}