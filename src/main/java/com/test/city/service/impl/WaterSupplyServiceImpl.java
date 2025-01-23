package com.test.city.service.impl;

import com.test.city.converter.WaterSupplyConverter;
import com.test.city.dto.water_supply.WaterSupplyInDto;
import com.test.city.dto.water_supply.WaterSupplyOutDto;
import com.test.city.model.WaterSupplyEntity;
import com.test.city.repository.WaterSupplyRepository;
import com.test.city.service.WaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WaterSupplyServiceImpl implements WaterSupplyService {

    @Autowired
    private WaterSupplyRepository waterSupplyRepository;

    @Autowired
    private WaterSupplyConverter waterSupplyConverter;

    @Override
    public void validateWaterSupply(WaterSupplyInDto waterSupplyInDto) {
        //Validate data
    }

    @Override
    public Long saveWaterSupply(WaterSupplyInDto waterSupplyInDto) {
        validateWaterSupply(waterSupplyInDto);
        WaterSupplyEntity waterSupplyEntity = waterSupplyConverter.toEntity(waterSupplyInDto);
        waterSupplyEntity = waterSupplyRepository.save(waterSupplyEntity);
        return waterSupplyEntity.getId();
    }

    @Override
    public List<WaterSupplyOutDto> getAllWaterSupply() {
        List<WaterSupplyEntity> waterSupplyEntities = waterSupplyRepository.findAll();
        List<WaterSupplyOutDto> waterSupplyOutDtos = new ArrayList<>();
        for (WaterSupplyEntity waterSupplyEntity : waterSupplyEntities) {
            waterSupplyOutDtos.add(waterSupplyConverter.toDto(waterSupplyEntity));
        }
        return waterSupplyOutDtos;
    }
}
