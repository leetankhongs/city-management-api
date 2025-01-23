package com.test.city.model;

import com.test.city.object_value.DisposalMethod;
import com.test.city.object_value.WasteType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class WasteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private WasteType type; // e.g., Organic, Plastic
    private Boolean collected; // true/false
    private DisposalMethod disposalMethod; // e.g., Recycled, Landfill
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt;
}