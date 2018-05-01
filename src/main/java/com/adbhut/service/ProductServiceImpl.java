package com.adbhut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbhut.model.Product;
import com.adbhut.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> listAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getProductById(Integer id) {
		return productRepo.findById(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	@Override
	public void deleteProduct(Integer id) {
		productRepo.delete(id);
	}

}
