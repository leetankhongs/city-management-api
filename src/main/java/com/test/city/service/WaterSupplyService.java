package com.test.city.service;

import com.test.city.dto.water_supply.WaterSupplyInDto;
import com.test.city.dto.water_supply.WaterSupplyOutDto;

import java.util.List;

public interface WaterSupplyService {
    void validateWaterSupply(WaterSupplyInDto waterSupplyInDto);
    Long saveWaterSupply(WaterSupplyInDto waterSupplyInDto);

    List<WaterSupplyOutDto> getAllWaterSupply();
}
