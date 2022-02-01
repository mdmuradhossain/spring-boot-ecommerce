package io.murad.ecommerce.service;


import io.murad.ecommerce.model.Payment;
import io.murad.ecommerce.model.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
