package com.example.franchise_api.service;

import com.example.franchise_api.model.Branch;
import com.example.franchise_api.model.Franchise;
import com.example.franchise_api.model.Product;
import com.example.franchise_api.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchiseService {

    private final FranchiseRepository repository;

    public FranchiseService(FranchiseRepository repository) {
        this.repository = repository;
    }

    public Franchise createFranchise(Franchise franchise) {
        return repository.save(franchise);
    }

    public Franchise addBranch(Long franchiseId, Branch branch) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();
        franchise.getBranches().add(branch);
        return repository.save(franchise);
    }

    public Franchise addProduct(Long franchiseId, Long branchId, Product product) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();

        Branch branch = franchise.getBranches()
                .stream()
                .filter(b -> b.getId().equals(branchId))
                .findFirst()
                .orElseThrow();

        branch.getProducts().add(product);
        return repository.save(franchise);
    }

    public Franchise deleteProduct(Long franchiseId, Long branchId, Long productId) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();

        Branch branch = franchise.getBranches()
                .stream()
                .filter(b -> b.getId().equals(branchId))
                .findFirst()
                .orElseThrow();

        branch.getProducts().removeIf(p -> p.getId().equals(productId));

        return repository.save(franchise);
    }

    public Franchise updateStock(Long franchiseId, Long branchId, Long productId, int stock) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();

        Branch branch = franchise.getBranches()
                .stream()
                .filter(b -> b.getId().equals(branchId))
                .findFirst()
                .orElseThrow();

        Product product = branch.getProducts()
                .stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow();

        product.setStock(stock);

        return repository.save(franchise);
    }

    // 7 - Obtener el producto con más stock POR SUCURSAL
    public List<Product> getTopProducts(Long franchiseId) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();

        return franchise.getBranches()
                .stream()
                .map(branch ->
                        branch.getProducts()
                                .stream()
                                .max(Comparator.comparing(Product::getStock))
                                .map(p -> {
                                    Product copy = new Product();
                                    copy.setId(p.getId());
                                    copy.setName(p.getName());
                                    copy.setStock(p.getStock());
                                    copy.setBranchName(branch.getName()); // <- agregado
                                    return copy;
                                })
                                .orElse(null)
                )
                .filter(p -> p != null)
                .collect(Collectors.toList());
    }
    
    // 8 - Obtener todos los productos
    public List<Product> getAllProducts(Long franchiseId) {
        Franchise franchise = repository.findById(franchiseId).orElseThrow();

        return franchise.getBranches()
                .stream()
                .flatMap(branch -> branch.getProducts().stream())
                .toList();
    }

}
