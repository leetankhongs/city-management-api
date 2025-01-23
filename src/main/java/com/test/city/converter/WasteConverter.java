package com.test.city.converter;

import com.test.city.dto.waste.WasteInDto;
import com.test.city.dto.waste.WasteOutDto;
import com.test.city.model.WasteEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WasteConverter extends BaseEntityConverter<WasteEntity, WasteInDto, WasteOutDto> {
    @Override
    public WasteEntity toEntity(WasteInDto dto) {
        WasteEntity wasteEntity = new WasteEntity();
        wasteEntity.setType(dto.getType());
        wasteEntity.setCollected(dto.getCollected());
        wasteEntity.setDisposalMethod(dto.getDisposalMethod());
        wasteEntity.setRecordedAt(new Date());

        return wasteEntity;
    }

    @Override
    public WasteOutDto toDto(WasteEntity entity) {
        WasteOutDto dto = new WasteOutDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setCollected(entity.getCollected());
        dto.setDisposalMethod(entity.getDisposalMethod());
        dto.setRecordedAt(entity.getRecordedAt());
        return dto;
    }
}
