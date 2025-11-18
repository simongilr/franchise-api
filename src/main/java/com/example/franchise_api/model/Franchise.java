package com.example.franchise_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();

    public Franchise() {
    }

    public Franchise(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Branch> getBranches() { return branches; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBranches(List<Branch> branches) { this.branches = branches; }
}
