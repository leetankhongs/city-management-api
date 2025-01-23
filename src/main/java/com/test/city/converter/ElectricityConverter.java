package com.test.city.converter;

import com.test.city.dto.electricity.ElectricityInDto;
import com.test.city.dto.electricity.ElectricityOutDto;
import com.test.city.model.ElectricityEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ElectricityConverter extends BaseEntityConverter<ElectricityEntity, ElectricityInDto, ElectricityOutDto> {
    @Override
    public ElectricityEntity toEntity(ElectricityInDto dto) {
        ElectricityEntity electricityEntity = new ElectricityEntity();
        electricityEntity.setCost(dto.getCost());
        electricityEntity.setConsumption(dto.getConsumption());
        electricityEntity.setReport(dto.getReport());
        electricityEntity.setRecordedAt(new Date());
        return electricityEntity;
    }

    @Override
    public ElectricityOutDto toDto(ElectricityEntity entity) {
        ElectricityOutDto dto = new ElectricityOutDto();
        dto.setId(entity.getId());
        dto.setCost(entity.getCost());
        dto.setConsumption(entity.getConsumption());
        dto.setReport(entity.getReport());
        dto.setRecordedAt(entity.getRecordedAt());
        return dto;
    }
}

