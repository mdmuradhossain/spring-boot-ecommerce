package io.murad.modern.ecommerce.service;

import io.murad.modern.ecommerce.model.ConfirmationToken;
import io.murad.modern.ecommerce.repository.ConfirmationTokenRepository;

public class ConfirmationTokenService {

	private ConfirmationTokenRepository confirmationTokenRepo;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenRepo.save(confirmationToken);
	}
	
	public void deleteConfirmationToken(Long id) {
		confirmationTokenRepo.deleteById(id);
	}
}
