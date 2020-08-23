package io.murad.modern.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.murad.modern.ecommerce.model.ConfirmationToken;
import io.murad.modern.ecommerce.repository.ConfirmationTokenRepository;

@Service
public class ConfirmationTokenService {

	private ConfirmationTokenRepository confirmationTokenRepo;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenRepo.save(confirmationToken);
	}
	
	public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {

		return confirmationTokenRepo.findConfirmationTokenByConfirmationToken(token);
	}
	
	public void deleteConfirmationToken(Long id) {
		confirmationTokenRepo.deleteById(id);
	}
}
