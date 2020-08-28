package io.murad.modern.ecommerce.service;

import java.util.List;

import io.murad.modern.ecommerce.model.Product;

public interface ProductService {

	public Product storeProduct(Product product);
	public List<Product> getProducts();
}
