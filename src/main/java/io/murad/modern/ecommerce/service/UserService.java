package io.murad.modern.ecommerce.service;

import java.text.MessageFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.murad.modern.ecommerce.model.ConfirmationToken;
import io.murad.modern.ecommerce.model.User;
import io.murad.modern.ecommerce.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	private ConfirmationTokenService confirmationTokenService;
	private EmailSenderService emailSenderService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, ConfirmationTokenService confirmationTokenService,
			EmailSenderService emailSenderService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.confirmationTokenService = confirmationTokenService;
		this.emailSenderService = emailSenderService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isPresent()) {
			return (UserDetails) optionalUser.get();
		} else {
			throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
		}
	}

	public void signUpUser(User user) {
		final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);

		final User createdUser = userRepository.save(user);
		final ConfirmationToken confirmationToken = new ConfirmationToken(user);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		sendConfirmationMail(user.getEmail(), confirmationToken.getConfirmationToken());
	}

	public void confirmUser(ConfirmationToken confirmationToken) {
		final User user = confirmationToken.getUser();
		user.isEnabled();
		userRepository.save(user);
		confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
	}

	public void sendConfirmationMail(String userMail, String token) {
		final SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(userMail);
		mailMessage.setSubject("Mail Confirmation Link");
		mailMessage.setFrom("<MAIL>");
		mailMessage.setText(
				"Thank You for registering, Please click on the below link to activate your account.\" + \"http://localhost:8080/sign-up/confirm?token=\"\r\n"
						+ token);
		emailSenderService.sendEmail(mailMessage);
	}
}
