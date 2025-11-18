package com.example.franchise_api.repository;

import com.example.franchise_api.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> { }
