package com.test.city.dto.waste;


import com.test.city.object_value.DisposalMethod;
import com.test.city.object_value.WasteType;
import lombok.Data;
import java.util.Date;

@Data
public class WasteOutDto {
    private Long id;
    private WasteType type; // e.g., Organic, Plastic
    private boolean collected; // true/false
    private DisposalMethod disposalMethod; // e.g., Recycled, Landfill
    private Date recordedAt;
}
