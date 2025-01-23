package com.test.city.service.impl;

import com.test.city.converter.ElectricityConverter;
import com.test.city.dto.electricity.ElectricityOutDto;
import com.test.city.model.ElectricityEntity;
import com.test.city.repository.ElectricityRepository;
import com.test.city.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectricityServiceImpl implements ElectricityService {

    @Autowired
    private ElectricityRepository electricityRepository;

    @Autowired
    private ElectricityConverter electricityConverter;;

    @Override
    public List<ElectricityOutDto> getElectricityList() {
        List<ElectricityEntity> electricityEntities = electricityRepository.findAll();
        List<ElectricityOutDto> electricityOutDtos = new ArrayList<>();
        for (ElectricityEntity electricityEntity : electricityEntities) {
            electricityOutDtos.add(electricityConverter.toDto(electricityEntity));
        }
        return electricityOutDtos;
    }
}
