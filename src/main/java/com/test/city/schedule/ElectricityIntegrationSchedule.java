package com.test.city.schedule;

import com.test.city.converter.ElectricityConverter;
import com.test.city.dto.electricity.ElectricityInDto;
import com.test.city.external_service.ExternalElectricityService;
import com.test.city.model.ElectricityEntity;
import com.test.city.repository.ElectricityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ElectricityIntegrationSchedule {

    @Autowired
    private ElectricityRepository electricityRepository;

    @Autowired
    private ElectricityConverter electricityConverter;


    @Autowired
    private ExternalElectricityService externalElectricityService;

    @Scheduled(fixedRate = 300000) // Every 5 minutes
    public void fetchElectricityData() {
        try {
            List<ElectricityInDto> electricityData = externalElectricityService.collectElectricityData();
            if(CollectionUtils.isEmpty(electricityData)) {
                return;
            }
            List<ElectricityEntity> entities = electricityData.stream()
                    .map(electricityConverter::toEntity)
                    .toList();

            electricityRepository.saveAll(entities);
        } catch (Exception ex) {
            System.err.println("Failed to fetch electricity data: " + ex.getMessage());
        }
    }
}
