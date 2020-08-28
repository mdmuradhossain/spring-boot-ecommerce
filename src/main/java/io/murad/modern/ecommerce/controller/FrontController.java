package io.murad.modern.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.murad.modern.ecommerce.model.Product;
import io.murad.modern.ecommerce.service.ProductService;

@Controller
public class FrontController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products",products);
		return "front/products";
	}
}
