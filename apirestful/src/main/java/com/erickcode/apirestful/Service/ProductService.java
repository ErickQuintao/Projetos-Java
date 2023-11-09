package com.erickcode.apirestful.Service;

import com.erickcode.apirestful.Model.ProductEntity;

public interface ProductService {
    ProductEntity getProductById(Long id);
    void saveProduct(ProductEntity product);
    void updateProduct(ProductEntity product);
    void deleteProduct(Long id);
}
