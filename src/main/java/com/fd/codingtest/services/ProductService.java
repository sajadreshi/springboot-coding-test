package com.fd.codingtest.services;

import java.util.List;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.model.ProductBean;


public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductBean productBean);
}
