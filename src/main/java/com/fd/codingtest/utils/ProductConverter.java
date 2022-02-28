package com.fd.codingtest.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.fd.codingtest.domain.Product;
import com.fd.codingtest.model.ProductBean;


@Component
public class ProductConverter {
   
    public ProductBean buildProductBean(Product product) {
    	ProductBean productBean = new ProductBean();
    	BeanUtils.copyProperties(product, productBean);
        return productBean;
    }
    
    public Product buildProduct(ProductBean productBean) {
    	Product product = new Product();
    	BeanUtils.copyProperties(productBean, product);
    	product.setLastUpdated(getCurrentTimeStamp());
        return product;
    }
    
    private Date getCurrentTimeStamp() {
    	Date in = new Date();
    	LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    	return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
