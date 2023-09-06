package com.example.ex14.entity;

import lombok.Data;

@Data
public class ResponseObject {
    private String status = "ok";
    private String message = "Successful";
    private Object data;

    public ResponseObject() {
        status = "ok";
        message = "Successful";
    }
}
