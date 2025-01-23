package com.test.city.controller.query.impl;

import com.test.city.controller.query.WaterSupplyQueryController;
import com.test.city.dto.BaseResponse;
import com.test.city.dto.water_supply.WaterSupplyOutDto;
import com.test.city.service.WaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaterSupplyQueryControllerImpl implements WaterSupplyQueryController {
    @Autowired
    private WaterSupplyService waterSupplyService;

    @Override
    public ResponseEntity<BaseResponse<List<WaterSupplyOutDto>>> getAllWaterSupply() {
        BaseResponse<List<WaterSupplyOutDto>> baseResponse = new BaseResponse<>();
        try {
            List<WaterSupplyOutDto> data = waterSupplyService.getAllWaterSupply();
            baseResponse.setIsSuccess(true);
            baseResponse.setMessage("Success");
            baseResponse.setData(data);
        } catch (Exception e) {
            baseResponse.setIsSuccess(false);
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(null);
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
