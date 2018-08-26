package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.Product;
import com.example.demo.dal.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("productServiceService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
      return productRepository.findAll();
    }
}
