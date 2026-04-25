package com.example.samplehttpclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssetReportNotFoundException extends  RuntimeException{
    public AssetReportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
