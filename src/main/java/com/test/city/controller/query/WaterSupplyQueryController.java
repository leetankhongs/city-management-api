package com.test.city.controller.query;

import com.test.city.dto.BaseResponse;
import com.test.city.dto.water_supply.WaterSupplyOutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/water-supplies")
public interface WaterSupplyQueryController {
    @GetMapping
    ResponseEntity<BaseResponse<List<WaterSupplyOutDto>>> getAllWaterSupply();
}
