package com.test.city.external_service.impl;

import com.test.city.dto.electricity.ElectricityInDto;
import com.test.city.external_service.ExternalElectricityService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalElectricityServiceImpl implements ExternalElectricityService {
    private static final String EXTERNAL_API_URL = "https://api.example.com/electricity-data";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ElectricityInDto> collectElectricityData() {
        ElectricityInDto[] electricityData = restTemplate.getForObject(EXTERNAL_API_URL, ElectricityInDto[].class);
        return Arrays.stream(electricityData).toList();
    }
}
