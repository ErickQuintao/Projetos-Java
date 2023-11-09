package com.erickcode.apirestful.Service;

import com.erickcode.apirestful.Model.ProductEntity;
import com.erickcode.apirestful.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Additional method to get all products (optional)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
