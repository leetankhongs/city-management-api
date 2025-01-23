package com.test.city.external_service;

import com.test.city.dto.electricity.ElectricityInDto;

import java.util.List;

public interface ExternalElectricityService {

    List<ElectricityInDto> collectElectricityData();
}
