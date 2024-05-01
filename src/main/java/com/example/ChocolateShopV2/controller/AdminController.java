package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.user.UserRegisterRequest;
import com.example.ChocolateShopV2.dto.user.UserRegisterResponse;
import com.example.ChocolateShopV2.service.AdminService;
import com.example.ChocolateShopV2.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request){
        return ResponseEntity.ok(adminService.register(request));
    }
}
