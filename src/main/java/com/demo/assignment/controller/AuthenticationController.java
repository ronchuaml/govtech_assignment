package com.demo.assignment.controller;

import com.demo.assignment.config.JwtUtil;
import com.demo.assignment.repository.UserRepository;
import com.demo.assignment.requestDTO.AuthenticationRequest;
import com.demo.assignment.responseDTO.AuthenticationResponse;
import com.demo.assignment.service.CustomUserDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthenticationController(CustomUserDetailsService customUserDetailsService,
                                    JwtUtil jwtUtil,
                                    PasswordEncoder passwordEncoder,
                                    UserRepository userRepository) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)  {
            String username = authenticationRequest.getUsername();
            String password = authenticationRequest.getPassword();

            if (!passwordEncoder.matches(password, userRepository.findByUsername(username).get().getPassword())) {
                throw new BadCredentialsException("Incorrect username or password");
            }

            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String jwtToken = jwtUtil.generateToken(userDetails.getUsername());

            return new AuthenticationResponse(jwtToken);

    }
}
