package com.fd.codingtest.operations;

import java.util.List;

import javax.validation.Valid;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.model.ProductBean;

public interface ProductOperations {

	List<Product> listAllProductsSorted();

	Product findProductById(String productId);

	Product createProduct(@Valid ProductBean productBean);

	String deleProduct(String id);

	List<Product> listAllProducts();

}
