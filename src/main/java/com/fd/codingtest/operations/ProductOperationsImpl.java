package com.fd.codingtest.operations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.exceptions.ProductException;
import com.fd.codingtest.model.ProductBean;
import com.fd.codingtest.services.ProductService;
import com.fd.codingtest.utils.ProductConverter;

@Service
public class ProductOperationsImpl implements ProductOperations {
	
	
	
	
	@Autowired
	private ProductService productService;
    
	@Autowired
    private ProductConverter productToProductBean;
	
	

	@Override
	public List<Product> listAllProductsSorted() {
		/**
		 * Implement logic to sort products on title.
		 */
		return null;
	}

	@Override
	public Product findProductById(String productId) {

		return Optional.ofNullable(productId)
				.map(productService::getById)
				.orElseThrow(()-> new ProductException("ProductId can not be empty"));
	}

	@Override
	public Product createProduct(ProductBean productBean) {
		
		return Optional.ofNullable(productBean)
				.map(productToProductBean::buildProduct)
				.map(productService::saveOrUpdate)
				.orElseThrow(()-> new ProductException("Product information may not be incomplete"));
				
		
	
	}

	@Override
	public String deleProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listAllProducts() {
		return productService.listAll();
	}

}
