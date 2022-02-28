package com.fd.codingtest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fd.codingtest.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
