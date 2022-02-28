package com.fd.codingtest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Products {

	private List<ProductBean> productBeans;

	public List<ProductBean> getProductBeans() {
		return productBeans;
	}

	public void setProductBeans(List<ProductBean> productsBeans) {
		this.productBeans = productsBeans;
	}

}
