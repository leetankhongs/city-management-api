package com.test.city.model;

import com.test.city.object_value.WaterSupplyStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class WaterSupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double consumption; // in liters
    private double cost; // in currency
    private WaterSupplyStatus status; // e.g., Normal, Disrupted
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt;

}
