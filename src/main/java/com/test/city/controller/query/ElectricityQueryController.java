package com.test.city.controller.query;

import com.test.city.dto.BaseResponse;
import com.test.city.dto.electricity.ElectricityOutDto;
import com.test.city.dto.waste.WasteOutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/electricities")
public interface ElectricityQueryController {
    @GetMapping
    ResponseEntity<BaseResponse<List<ElectricityOutDto>>> getAllElectricities();
}
