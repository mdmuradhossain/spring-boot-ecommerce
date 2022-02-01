package io.murad.ecommerce.service.impl;

import io.murad.ecommerce.model.UserPayment;
import io.murad.ecommerce.repository.UserPaymentRepository;
import io.murad.ecommerce.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).get();
	}
	
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
} 
