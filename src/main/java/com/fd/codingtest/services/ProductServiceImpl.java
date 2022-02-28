package com.fd.codingtest.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.exceptions.ProductException;
import com.fd.codingtest.model.ProductBean;
import com.fd.codingtest.repositories.ProductRepository;
import com.fd.codingtest.utils.ProductConverter;


@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class.getName());

	@Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductConverter productConverter;

 


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); 
        return products;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id)
        		.orElseThrow(()-> new ProductException("Product Not found!"));
    }

    @Override
    public Product saveOrUpdate(Product product) {
      return productRepository.save(product);
        
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductBean productBean) {
        Product savedProduct = saveOrUpdate(productConverter.buildProduct(productBean));
        logger.info("Saved Product Id: {} successfully ",savedProduct.getProductId());
        return savedProduct;
    }
}
