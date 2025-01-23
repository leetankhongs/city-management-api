package com.test.city.dto.waste;

import com.test.city.object_value.DisposalMethod;
import com.test.city.object_value.WasteType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WasteInDto {
    private WasteType type; // e.g., Organic, Plastic
    private Boolean collected; // true/false
    private DisposalMethod disposalMethod; // e.g., Recycled, Landfill
}
