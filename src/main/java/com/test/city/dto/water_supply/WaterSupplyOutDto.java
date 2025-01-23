package com.test.city.dto.water_supply;

import com.test.city.object_value.WaterSupplyStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class WaterSupplyOutDto {
    private Long id;
    private Double consumption;
    private Double cost;
    private WaterSupplyStatus status;
    private Date recordedAt;
}
