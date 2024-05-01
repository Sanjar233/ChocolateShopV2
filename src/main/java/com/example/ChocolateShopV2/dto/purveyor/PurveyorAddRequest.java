package com.example.ChocolateShopV2.dto.purveyor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurveyorAddRequest {
    private String name;
    private String address;
    private String phone_number;
}
