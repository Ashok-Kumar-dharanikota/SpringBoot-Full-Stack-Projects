package com.application.two.Service;

import com.application.two.Model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProduct(Long Id);
    Product updateProduct(Long Id, Product product);
    void removeProduct(Long Id);
    void removeAllProducts();

}
