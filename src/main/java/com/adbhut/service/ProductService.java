package com.adbhut.service;

import java.util.List;
import java.util.Optional;

import com.adbhut.model.Product;

public interface ProductService {

	List<Product> listAllProducts();

	Optional<Product> getProductById(Integer id);

	void deleteProduct(Integer id);

	Product saveProduct(Product product);

}
