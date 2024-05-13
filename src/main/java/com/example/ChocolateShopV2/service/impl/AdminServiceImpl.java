package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.config.JwtService;
import com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;
import com.example.ChocolateShopV2.entities.User;
import com.example.ChocolateShopV2.exception.BadCredentialsException;
import com.example.ChocolateShopV2.repositories.UserRepository;
import com.example.ChocolateShopV2.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent())
            throw new BadCredentialsException("User with username: " + request.getUsername() + " is already exist!");
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setActive(true);
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        System.out.println(token);
        return new UserRegisterResponse(token);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public void deactivateUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user)
    }
}
