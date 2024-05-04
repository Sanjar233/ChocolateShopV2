package com.example.ChocolateShopV2.dto.purveyor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurveyorStatusRequest {
    private Long id;
    private boolean status;
}
