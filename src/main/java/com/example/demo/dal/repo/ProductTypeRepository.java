package com.example.demo.dal.repo;

import com.example.demo.dal.dao.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productTypeRepository")
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findById(int id);
}