package com.example.ChocolateShopV2.mappers.impl;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorResponse;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.mappers.PurveyorMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurveyorMapperImpl implements PurveyorMapper {
    @Override
    public PurveyorResponse toDto(Purveyor purveyor) {
        PurveyorResponse purveyorResponse = new PurveyorResponse();
        purveyorResponse.setId(purveyor.getId());
        purveyorResponse.setName(purveyor.getName());
        purveyorResponse.setAddress(purveyor.getAddress());
        purveyorResponse.setPhone_number(purveyor.getPhone_number());
        purveyorResponse.setActive(purveyor.isActive());
        purveyorResponse.setTransactions(purveyor.getTransactions());
        purveyorResponse.setProducts(purveyor.getProducts());
        return purveyorResponse;
    }

    @Override
    public List<PurveyorResponse> toDtoS(List<Purveyor> allPurveyors) {
        List<PurveyorResponse> responses = new ArrayList<>();
        for(Purveyor purveyor : allPurveyors) {
            responses.add(toDto(purveyor));
        }
        return responses;
    }
}
