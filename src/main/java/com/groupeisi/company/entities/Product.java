package com.groupeisi.company.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ref;

    @Column(nullable = false)
    private String name;

    private double stock;

    // Constructors
    public Product() {}
    public Product(String ref, String name, double stock) {
        this.ref = ref; this.name = name; this.stock = stock;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getStock() { return stock; }
    public void setStock(double stock) { this.stock = stock; }
}