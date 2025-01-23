package com.test.city.controller.command.impl;

import com.test.city.controller.command.WaterSupplyCommandController;
import com.test.city.dto.BaseResponse;
import com.test.city.dto.water_supply.WaterSupplyInDto;
import com.test.city.service.WaterSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaterSupplyCommandControllerImpl implements WaterSupplyCommandController {

    @Autowired
    private WaterSupplyService waterSupplyService;


    @Override
    public ResponseEntity<BaseResponse<Long>> addWaterSupply(WaterSupplyInDto waterSupplyInDto) {
        BaseResponse<Long> baseResponse = new BaseResponse<>();
        try {
            Long id = waterSupplyService.saveWaterSupply(waterSupplyInDto);
            baseResponse.setIsSuccess(true);
            baseResponse.setMessage("Success");
            baseResponse.setData(id);
        } catch (Exception e) {
            baseResponse.setIsSuccess(false);
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(null);
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

    }
}
