package com.test.city.controller.query.impl;

import com.test.city.controller.query.WasteQueryController;
import com.test.city.dto.BaseResponse;
import com.test.city.dto.waste.WasteOutDto;
import com.test.city.service.WasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WasteQueryControllerImpl implements WasteQueryController {

    @Autowired
    private WasteService wasteService;

    @Override
    public ResponseEntity<BaseResponse<List<WasteOutDto>>> getAllWastes() {
        BaseResponse<List<WasteOutDto>> baseResponse = new BaseResponse<>();
        try {
            List<WasteOutDto> data = wasteService.getWasteData();
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
