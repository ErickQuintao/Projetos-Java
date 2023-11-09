package com.erickcode.apirestful.Repository;

import com.erickcode.apirestful.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
