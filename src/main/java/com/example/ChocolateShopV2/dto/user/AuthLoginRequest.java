package com.example.ChocolateShopV2.dto.user;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthLoginRequest {
    private String username;
    private String password;
}
