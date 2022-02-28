package com.fd.codingtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.model.ProductBean;
import com.fd.codingtest.operations.ProductOperations;


@RestController
@RequestMapping(value="/codingtest",produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {
	
    @Autowired
     private ProductOperations productOperations;
  

    @GetMapping({"/product/all"})
    public List<Product> listProducts(){
       return productOperations.listAllProducts();
    }
    
    @GetMapping({"/product/sort"})
    public List<Product> listProductsSorted(){
       return productOperations.listAllProductsSorted();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") String productId){
        
        return productOperations.findProductById(productId);
    }

    @PostMapping(value = "/product")
    public Product saveOrUpdateProduct(@RequestBody ProductBean productBean){

    	  return productOperations.createProduct(productBean);
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable String id){
    	 return productOperations.deleProduct(id);
    }
}
