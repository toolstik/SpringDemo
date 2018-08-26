package com.example.demo.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.example.demo.dal.dao.Product;
import com.example.demo.models.ProductListItemModel;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController{

    @Autowired
    private ProductService productService;

    @RequestMapping(value = { "/products" }, method = RequestMethod.GET)
    public ModelAndView productsPage(Model model) {
        ModelAndView result = new ModelAndView();
        result.setViewName("productsPage");

        List<ProductListItemModel> products = productService.findAll()
                .stream()
        		.map(new Function<Product, ProductListItemModel>(){
        			
        			@Override
        			public ProductListItemModel apply(Product product) {
                        ProductListItemModel productModel = new ProductListItemModel();
                        productModel.setName(product.getName());
                        productModel.setDescription(product.getDescription());
                        productModel.setCreateDate(product.getCreateDate());
                        productModel.setPrice(product.getPrice());
                        productModel.setQuantity(product.getQuantity());
                        productModel.setType(product.getType().getName());
                        return productModel;
        			}
                })
                .collect(Collectors.toList());

        result.addObject("products", products);
        return result;
    }

}