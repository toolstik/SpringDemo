package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.Product;
import com.example.demo.dal.dao.ProductType;
import com.example.demo.dal.repo.ProductRepository;
import com.example.demo.dal.repo.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("productServiceService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<Product> findAll() {
      return productRepository.findAll();
    }

    @Override
    public void save(Product input) {
      productRepository.saveAndFlush(input);
    }

    @Override
    public List<ProductType> findAllTypes() {
      return productTypeRepository.findAll();
    }

    @Override
    public ProductType findTypeById(int id) {
      return productTypeRepository.findById(id);
    }
}
