package io.murad.modern.ecommerce.model;

import javax.persistence.Entity;

@Entity
public class Role {

	private Long id;
	private String roleName;
	
	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
