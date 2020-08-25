package io.murad.modern.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {

	private Long id;
	private String brandName;
}
