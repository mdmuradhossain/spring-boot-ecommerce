package io.murad.modern.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	private Long id;
	private String categoryName;
	
}
