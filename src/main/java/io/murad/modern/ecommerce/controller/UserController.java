package io.murad.modern.ecommerce.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.murad.modern.ecommerce.model.ConfirmationToken;
import io.murad.modern.ecommerce.model.User;
import io.murad.modern.ecommerce.service.ConfirmationTokenService;
import io.murad.modern.ecommerce.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	private ConfirmationTokenService confirmationTokenService;

	@GetMapping("/sign-in")
	String signIn() {

		return "signIn";
	}

	@GetMapping("/sign-up")
	String signUp() {

		return "signUp";
	}

	@PostMapping("/sign-up")
	String signUp(User user) {

		userService.signUpUser(user);

		return "redirect:/signIn";
	}

	@GetMapping("/confirm")
	String confirmMail(@RequestParam("token") String token) {

		Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

		optionalConfirmationToken.ifPresent(userService::confirmUser);

		return "/signIn";
	}

}
