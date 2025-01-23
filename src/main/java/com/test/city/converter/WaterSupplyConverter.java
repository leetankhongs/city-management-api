package com.test.city.converter;

import com.test.city.dto.water_supply.WaterSupplyInDto;
import com.test.city.dto.water_supply.WaterSupplyOutDto;
import com.test.city.model.WaterSupplyEntity;
import com.test.city.object_value.WaterSupplyStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WaterSupplyConverter extends BaseEntityConverter<WaterSupplyEntity, WaterSupplyInDto, WaterSupplyOutDto> {
    @Override
    public WaterSupplyEntity toEntity(WaterSupplyInDto dto) {
        WaterSupplyEntity waterSupply = new WaterSupplyEntity();
        waterSupply.setConsumption(dto.getConsumption());
        waterSupply.setCost(dto.getCost());
        waterSupply.setStatus(dto.getStatus());
        waterSupply.setRecordedAt(new Date());
        return waterSupply;
    }

    @Override
    public WaterSupplyOutDto toDto(WaterSupplyEntity entity) {
        WaterSupplyOutDto dto = new WaterSupplyOutDto();
        dto.setId(entity.getId());
        dto.setConsumption(entity.getConsumption());
        dto.setCost(entity.getCost());
        dto.setStatus(entity.getStatus());
        dto.setRecordedAt(entity.getRecordedAt());
        return dto;
    }
}

