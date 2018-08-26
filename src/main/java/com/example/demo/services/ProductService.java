package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.Product;
import com.example.demo.dal.dao.ProductType;

public interface ProductService {
	public List<Product> findAll();
	public void save(Product input);
	public List<ProductType> findAllTypes();
	public ProductType findTypeById(int id);

}