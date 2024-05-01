package com.example.ChocolateShopV2.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class AuthLoginResponse {
    @JsonProperty("access_token")
    private String accessToken;
}
