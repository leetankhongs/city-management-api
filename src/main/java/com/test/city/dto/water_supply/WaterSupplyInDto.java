package com.test.city.dto.water_supply;

import com.test.city.object_value.WaterSupplyStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WaterSupplyInDto {
    @NotNull
    private Double consumption;
    @NotNull
    private Double cost;
    @NotNull
    private WaterSupplyStatus status;
}
