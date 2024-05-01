package com.example.ChocolateShopV2.service.impl;

import com.example.ChocolateShopV2.dto.purveyor.PurveyorAddRequest;
import com.example.ChocolateShopV2.entities.Purveyor;
import com.example.ChocolateShopV2.repositories.PurveyorRepository;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PurveyorServiceImpl implements PurveyorService {
    private final PurveyorRepository purveyorRepository;

    @Override
    public void add_purveyor(PurveyorAddRequest request){
        Purveyor purveyor = new Purveyor();
        purveyor.setName(request.getName());
        purveyor.setAddress(request.getAddress());
        purveyor.setPhone_number(request.getPhone_number());
        purveyorRepository.save(purveyor);
    }
}
