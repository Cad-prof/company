package com.groupeisi.company.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sales {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateP;

    private double quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Sales() {}
    // Getters & Setters
    public Long getId() { return id; }
    public Date getDateP() { return dateP; } public void setDateP(Date dateP) { this.dateP = dateP; }
    public double getQuantity() { return quantity; } public void setQuantity(double quantity) { this.quantity = quantity; }
    public Product getProduct() { return product; } public void setProduct(Product product) { this.product = product; }
}