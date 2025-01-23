package com.test.city.dto.electricity;

import com.test.city.object_value.ReportType;
import lombok.Data;

import java.util.Date;

@Data
public class ElectricityOutDto {
    private Long id;
    private Double consumption; // in kWh
    private Double cost; // in currency
    private ReportType report; // e.g., Outage, Normal
    private Date recordedAt;
}
