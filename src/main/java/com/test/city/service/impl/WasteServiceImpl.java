package com.test.city.service.impl;

import com.test.city.converter.WasteConverter;
import com.test.city.dto.waste.WasteInDto;
import com.test.city.dto.waste.WasteOutDto;
import com.test.city.model.WasteEntity;
import com.test.city.object_value.DisposalMethod;
import com.test.city.object_value.WasteType;
import com.test.city.repository.WasteRepository;
import com.test.city.service.WasteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class WasteServiceImpl implements WasteService {
    @Autowired
    private WasteRepository wasteRepository;

    @Autowired
    private WasteConverter wasteConverter;


    @Override
    public void validateWasteData(WasteInDto wasteInDto) {
        Assert.notNull(wasteInDto.getType(), "Waste type is incorrect");
        Assert.notNull(wasteInDto.getDisposalMethod(), "Disposal Method is incorrect");
        Assert.notNull(wasteInDto.getCollected(), "Is collected is incorrect");

        // Validate waste data
    }

    @Override
    public void updateWasteData(MultipartFile file) {
        List<WasteInDto> wasteInDtos = getWasteData(file);
        for (WasteInDto wasteInDto : wasteInDtos) {
            validateWasteData(wasteInDto);
        }
        List<WasteEntity> wasteEntities = new ArrayList<>();
        for (WasteInDto wasteInDto : wasteInDtos) {
            wasteEntities.add(wasteConverter.toEntity(wasteInDto));
        }
        wasteRepository.saveAll(wasteEntities);
    }

    @Override
    public List<WasteOutDto> getWasteData() {
        List<WasteEntity> wasteEntities = wasteRepository.findAll();
        List<WasteOutDto> wasteOutDtos = new ArrayList<>();
        for (WasteEntity wasteEntity : wasteEntities) {
            wasteOutDtos.add(wasteConverter.toDto(wasteEntity));
        }
        return wasteOutDtos;
    }

    @Override
    public void saveWasteData(WasteInDto inputDto) {
        wasteRepository.save(wasteConverter.toEntity(inputDto));
    }

    private List<WasteInDto> getWasteData(MultipartFile file) {
        List<WasteInDto> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                WasteInDto waste = new WasteInDto();
                waste.setType(WasteType.findSimilar(data[0]));
                waste.setCollected(Boolean.valueOf(data[1]));
                waste.setDisposalMethod(DisposalMethod.findSimilar(data[2]));
                result.add(waste);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing file", e);
        }
        return result;
    }
}
