package com.adbhut.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adbhut.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	public List<Product> findAll();

	public Optional<Product> findById(Integer id);
}
