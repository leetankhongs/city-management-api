package com.test.city.service;

import com.test.city.dto.electricity.ElectricityOutDto;

import java.util.List;

public interface ElectricityService {
    List<ElectricityOutDto> getElectricityList();
}
