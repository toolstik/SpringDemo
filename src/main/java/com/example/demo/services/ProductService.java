package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.Product;

public interface ProductService {
	public List<Product> findAll();
}