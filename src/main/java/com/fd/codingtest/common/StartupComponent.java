package com.fd.codingtest.common;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.codingtest.model.Products;
import com.fd.codingtest.operations.ProductOperations;

@Component
public class StartupComponent implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(StartupComponent.class.getName());
	@Autowired
	private ProductOperations productOperations;

	@Override
	public void run(String... args) throws Exception {
		Products products = fetchProducts();
		Optional.ofNullable(products).map(Products::getProductBeans).orElse(Collections.emptyList())
				.forEach(productOperations::createProduct);
	}

	private Products fetchProducts() {

		try {
			return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(
					IOUtils.toString(getClass().getClassLoader().getResourceAsStream("product/products.json"),
							StandardCharsets.UTF_8),
					Products.class);

		} catch (Exception e) {
			logger.error("Could parse products json due to {} ", e.getMessage());
		}
		return null;
	}

}
