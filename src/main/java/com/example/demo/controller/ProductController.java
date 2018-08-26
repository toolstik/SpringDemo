package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.example.demo.dal.dao.Product;
import com.example.demo.dal.dao.ProductType;
import com.example.demo.models.ProductListItemModel;
import com.example.demo.models.ProductSubmitModel;
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

    @RequestMapping(value = { "/products/list" }, method = RequestMethod.GET)
    public ModelAndView productsListPage(Model model) {
        ModelAndView result = new ModelAndView();
        result.setViewName("productsListPage");

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

    @RequestMapping(value = {"/products/add"}, method = RequestMethod.GET)
    public ModelAndView showAddProductPage(Model model){
        ModelAndView result = new ModelAndView();
        result.setViewName("productsAddPage");

        Map<Integer, String> productTypes = productService.findAllTypes()
            .stream()
            .collect(Collectors.toMap(ProductType::getId, ProductType::getName));

        result.addObject("productTypes", productTypes);
        result.addObject("product", new ProductSubmitModel());
        return result;
    }

    @RequestMapping(value = {"/products/add"}, method = RequestMethod.POST)
    public String submitAddProductPage(
        ProductSubmitModel product){
        Product daoProduct = new Product();
        daoProduct.setName(product.getName());
        daoProduct.setDescription(product.getDescription());
        daoProduct.setPrice(product.getPrice());
        daoProduct.setQuantity(product.getQuantity());
        daoProduct.setCreateDate(new Date());
        ProductType productType = productService.findTypeById(product.getTypeId());
        daoProduct.setType(productType);

        productService.save(daoProduct);

        return "redirect:/products/list";
    }

}