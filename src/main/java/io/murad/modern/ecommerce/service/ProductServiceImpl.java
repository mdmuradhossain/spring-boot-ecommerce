package io.murad.modern.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.murad.modern.ecommerce.model.Product;
import io.murad.modern.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product storeProduct(Product product) {
		return productRepository.save(product);
	}

}
