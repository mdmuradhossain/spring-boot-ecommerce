package io.murad.ecommerce.service;


import io.murad.ecommerce.model.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
