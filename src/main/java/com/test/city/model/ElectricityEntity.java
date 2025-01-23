package com.test.city.model;

import com.test.city.object_value.ReportType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "electricity")
public class ElectricityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double consumption; // in kWh
    private double cost; // in currency
    private ReportType report; // e.g., Outage, Normal
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt;
}
