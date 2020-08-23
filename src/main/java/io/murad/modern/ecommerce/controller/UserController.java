package io.murad.modern.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@Autowired
	public UserController(UserService userService, ConfirmationTokenService confirmationTokenService) {
		this.userService = userService;
		this.confirmationTokenService = confirmationTokenService;
	}

	@GetMapping("/sign-in")
	String signIn() {
		return "signIn";
	}

	@GetMapping("/sign-up")
	String signUp(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "signUp";
	}

	@PostMapping("/sign-up")
	String signUp(@ModelAttribute("user") User user) {
		userService.signUpUser(user);

		return "redirect:/signIn";
	}

	@GetMapping("/confirm")
	String confirmMail(@RequestParam("token") String token) {

		Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService
				.findConfirmationTokenByToken(token);

		optionalConfirmationToken.ifPresent(userService::confirmUser);

		return "/signIn";
	}

}
