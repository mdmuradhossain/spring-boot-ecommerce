package io.murad.ecommerce.service;


import io.murad.ecommerce.model.ShippingAddress;
import io.murad.ecommerce.model.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
