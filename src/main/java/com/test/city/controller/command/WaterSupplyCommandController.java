package com.test.city.controller.command;

import com.test.city.dto.BaseResponse;
import com.test.city.dto.water_supply.WaterSupplyInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/water-supplies")
public interface WaterSupplyCommandController {

    @PostMapping
    ResponseEntity<BaseResponse<Long>> addWaterSupply(@RequestBody WaterSupplyInDto waterSupplyInDto);

}
