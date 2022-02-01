package io.murad.ecommerce.service;


import io.murad.ecommerce.model.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
