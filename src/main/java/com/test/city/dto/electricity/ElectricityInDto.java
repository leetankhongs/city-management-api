package com.test.city.dto.electricity;

import com.test.city.object_value.ReportType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ElectricityInDto {

    @NotNull
    private Double consumption; // in kWh
    @NotNull
    private Double cost; // in currency
    @NotNull
    private ReportType report; // e.g., Outage, Normal
}
