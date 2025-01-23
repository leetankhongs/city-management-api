package com.test.city.dto;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private String message;
    private T data;
    private Boolean isSuccess;
}
