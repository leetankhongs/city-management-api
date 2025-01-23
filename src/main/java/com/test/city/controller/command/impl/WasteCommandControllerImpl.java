package com.test.city.controller.command.impl;

import com.test.city.controller.command.WasteCommandController;
import com.test.city.dto.BaseResponse;
import com.test.city.service.WasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class WasteCommandControllerImpl implements WasteCommandController {

    @Autowired
    private WasteService wasteService;

    @Override
    public ResponseEntity<BaseResponse<Object>> updateWasteData(MultipartFile file) {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        try {
            wasteService.updateWasteData(file);
            baseResponse.setIsSuccess(true);
            baseResponse.setMessage("Success");
        } catch (Exception e) {
            baseResponse.setIsSuccess(false);
            baseResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
