
package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.config.JwtService;
import com.example.ChocolateShopV2.dto.user.AuthLoginRequest;
import com.example.ChocolateShopV2.dto.user.AuthLoginResponse;
import com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;
import com.example.ChocolateShopV2.entities.User;
import com.example.ChocolateShopV2.exception.BadCredentialsException;
import com.example.ChocolateShopV2.repositories.UserRepository;
import com.example.ChocolateShopV2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent())
            throw new BadCredentialsException("User with username: " + request.getUsername() + " is already exist!");
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        System.out.println(token);
        return new UserRegisterResponse(token);
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        User user = userRepository.findByUsername(authLoginRequest.getUsername()).orElseThrow();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authLoginRequest.getUsername(),
                            authLoginRequest.getPassword()
                    ));
        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new BadCredentialsException("Credentials are incorrect!");
        }
        String token = jwtService.generateToken(user);
        return AuthLoginResponse.builder()
                .accessToken(token)
                .build();
    }
}