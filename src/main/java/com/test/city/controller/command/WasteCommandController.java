package com.test.city.controller.command;

import com.test.city.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/api/wastes")
public interface WasteCommandController {
    @PostMapping("/upload")
    ResponseEntity<BaseResponse<Object>> updateWasteData(@RequestParam("file") MultipartFile file);
}
