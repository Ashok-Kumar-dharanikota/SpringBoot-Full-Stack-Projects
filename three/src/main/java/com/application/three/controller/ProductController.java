package com.application.three.controller;

import com.application.three.model.Product;
import com.application.three.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {

        if(productRepository.existsById(productId)) {
            updatedProduct.setId(productId);
            return productRepository.save(updatedProduct);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productRepository.deleteById(productId);
    }
}
