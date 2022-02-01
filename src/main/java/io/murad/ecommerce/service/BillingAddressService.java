package io.murad.ecommerce.service;


import io.murad.ecommerce.model.BillingAddress;
import io.murad.ecommerce.model.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
