package io.murad.modern.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	private Long id;
	private String productName;
	private long productPrice;
	private String thumbnail;
	private String productDetails;
	
}
