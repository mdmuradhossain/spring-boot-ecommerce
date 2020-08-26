package io.murad.modern.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.murad.modern.ecommerce.model.Product;
import io.murad.modern.ecommerce.service.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/showProductForm")
	public String showProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "admin/product/add";
	}
	
	@PostMapping("/addProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.storeProduct(product);
		return "admin/product/products";
	}
}
