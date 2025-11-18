package com.example.franchise_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Product> getProducts() { return products; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProducts(List<Product> products) { this.products = products; }
}
