package com.adbhut.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.adbhut.model.Product;
import com.adbhut.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	private UriComponentsBuilder uriBuilder;

	@Autowired
	public ProductController(ProductService productService, UriComponentsBuilder uriBuilder) {
		this.productService = productService;
		this.uriBuilder = uriBuilder;
	}

	@GetMapping(value = "/")
	public List<Product> list() {
		return productService.listAllProducts();
	}

	@GetMapping(value = "/{id}/product")
	public Product showProduct(@PathVariable Integer id) {
		return productService.getProductById(id).get();
	}

	@PostMapping(value = "/")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.saveProduct(product);
		UriComponents uriComponents = uriBuilder.path("/{id}/product").buildAndExpand(createdProduct.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();

	}

	@PutMapping(value = "/{id}/product")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id).get();
		storedProduct.setDescription(product.getDescription());
		storedProduct.setImageUrl(product.getImageUrl());
		storedProduct.setPrice(product.getPrice());
		productService.saveProduct(storedProduct);
		return ResponseEntity.ok("Product updated successfully");
	}

	@DeleteMapping(value = "/{id}/product")
	public void delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}

}
