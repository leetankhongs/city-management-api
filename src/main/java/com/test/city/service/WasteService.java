package com.test.city.service;

import com.test.city.dto.waste.WasteInDto;
import com.test.city.dto.waste.WasteOutDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface WasteService {
    void validateWasteData(WasteInDto wasteInDto);
    void updateWasteData(MultipartFile file);

    List<WasteOutDto> getWasteData();

    void saveWasteData(WasteInDto inputDto);

}
