package com.application.two.Service;

import com.application.two.Exceptions.ProductNotFoundException;
import com.application.two.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImp implements ProductService {

    private final List<Product> ProductList = new ArrayList<>();
    private Long productIdCounter = 1L;

    @Override
    public Product addProduct(Product product) {
        product.setId(productIdCounter++);
        ProductList.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductList;
    }

    @Override
    public Product getProduct(Long Id) {
        return ProductList.stream()
                .filter(product -> product.getId().equals(Id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + Id));
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = getProduct(productId);
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        return existingProduct;
    }

    @Override
    public void removeProduct(Long Id) {
        Product productToDelete = getProduct(Id);
        ProductList.remove(productToDelete);
    }

    @Override
    public void removeAllProducts() {
        ProductList.clear();
    }
}
