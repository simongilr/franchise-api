package com.example.franchise_api.controller;

import com.example.franchise_api.model.Branch;
import com.example.franchise_api.model.Franchise;
import com.example.franchise_api.model.Product;
import com.example.franchise_api.service.FranchiseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchise")
public class FranchiseController {

    private final FranchiseService service;

    public FranchiseController(FranchiseService service) {
        this.service = service;
    }

    // 2 - Crear franquicia
    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return service.createFranchise(franchise);
    }

    // 3 - Agregar sucursal
    @PostMapping("/{id}/branch")
    public Franchise addBranch(@PathVariable Long id, @RequestBody Branch branch) {
        return service.addBranch(id, branch);
    }

    // 4 - Agregar producto
    @PostMapping("/{id}/branch/{branchId}/product")
    public Franchise addProduct(@PathVariable Long id, @PathVariable Long branchId, @RequestBody Product product) {
        return service.addProduct(id, branchId, product);
    }

    // 5 - Eliminar producto
    @DeleteMapping("/{id}/branch/{branchId}/product/{productId}")
    public Franchise deleteProduct(
            @PathVariable Long id,
            @PathVariable Long branchId,
            @PathVariable Long productId
    ) {
        return service.deleteProduct(id, branchId, productId);
    }

    // 6 - Actualizar stock
    @PutMapping("/{id}/branch/{branchId}/product/{productId}/stock/{stock}")
    public Franchise updateStock(
            @PathVariable Long id,
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @PathVariable int stock
    ) {
        return service.updateStock(id, branchId, productId, stock);
    }

    // 7 - Productos con mayor stock por sucursal de una franquicia
    @GetMapping("/{id}/top-products")
    public List<Product> getTopProducts(@PathVariable Long id) {
        return service.getTopProducts(id);
    }
    
    @GetMapping("/{id}/products")
    public List<Product> getAllProducts(@PathVariable Long id) {
        return service.getAllProducts(id);
    }
}
