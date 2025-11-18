package com.example.franchise_api.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stock;
    private String branchName;
    
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public Product() {
    }

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStock(int stock) { this.stock = stock; }
}
