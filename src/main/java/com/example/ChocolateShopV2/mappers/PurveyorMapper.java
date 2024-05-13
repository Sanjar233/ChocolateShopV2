package com.example.ChocolateShopV2.mappers;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorResponse;
import com.example.ChocolateShopV2.entities.Purveyor;

import java.util.List;

public interface PurveyorMapper {
    PurveyorResponse toDto(Purveyor purveyor);
    List<PurveyorResponse> toDtoS(List<Purveyor> allPurveyors);
}
