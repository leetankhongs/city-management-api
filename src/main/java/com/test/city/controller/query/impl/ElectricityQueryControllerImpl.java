package com.test.city.controller.query.impl;

import com.test.city.controller.query.ElectricityQueryController;
import com.test.city.dto.BaseResponse;
import com.test.city.dto.electricity.ElectricityOutDto;
import com.test.city.dto.waste.WasteOutDto;
import com.test.city.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElectricityQueryControllerImpl implements ElectricityQueryController {

    @Autowired
    private ElectricityService electricityService;

    @Override
    public ResponseEntity<BaseResponse<List<ElectricityOutDto>>> getAllElectricities() {
        BaseResponse<List<ElectricityOutDto>> baseResponse = new BaseResponse<>();
        try {
            List<ElectricityOutDto> data = electricityService.getElectricityList();
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
