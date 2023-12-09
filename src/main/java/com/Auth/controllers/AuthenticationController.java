package com.Auth.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

import com.Auth.DTO.AuthenticationDTO;
import com.Auth.DTO.RegisterUserDTO;
import com.Auth.DTO.LoginResponseDTO;
import com.Auth.entities.User;
import com.Auth.enums.UserRole;
import com.Auth.infra.security.TokenService;
import com.Auth.repositories.UserRepository;
import com.Auth.services.UserRoleService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody AuthenticationDTO data) {
	    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
	    
	    var auth = this.authenticationManager.authenticate(usernamePassword);

	    var token = tokenService.generateToken((User) auth.getPrincipal());

	    var user = (User) auth.getPrincipal(); 

	    System.out.println("Token gerado: " + token + " Role retornada:" + user.getRole().getRole() + " ID:" + user.getId());
	    
	    return ResponseEntity.ok(new LoginResponseDTO(token, user.getRole().getRole(), user.getId()));

	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody RegisterUserDTO data) {
		if (this.repository.findByLogin(data.login()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.phone(), data.role());

		this.repository.save(newUser);

		return ResponseEntity.ok().build();
	}

}
