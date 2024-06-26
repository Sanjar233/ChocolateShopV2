package com.example.ChocolateShopV2.dto.user;

import com.example.ChocolateShopV2.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private String username;
    private String email;
    private String password;
    private Role role;
}
