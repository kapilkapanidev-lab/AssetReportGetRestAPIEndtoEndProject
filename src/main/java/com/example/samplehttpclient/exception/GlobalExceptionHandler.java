package com.example.samplehttpclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AssetReportNotFoundException.class)
    public ResponseEntity<ExceptionStatus> handleAssetReportNotFoundException(AssetReportNotFoundException assetReportNotFoundException) {
        ExceptionStatus status = ExceptionStatus.builder()
                .statusCode(404)
                .message("No asset found")
                .timestamp(new Date())
                .build();
        return new ResponseEntity<ExceptionStatus>(status, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExternalAPIException.class)
    public ResponseEntity<ExceptionStatus> handleExternalAPIException(ExternalAPIException externalAPIException){
        ExceptionStatus status = ExceptionStatus.builder()
                .statusCode(502)
                .message("Something is not right withj the api")
                .timestamp(new Date())
                .build();
        return new ResponseEntity<ExceptionStatus>(status, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<ExceptionStatus> handleServerError(ServerError serverError) {
        ExceptionStatus status = ExceptionStatus.builder()
                .statusCode(500)
                .message("Server screwed up")
                .timestamp(new Date())
                .build();
        return new ResponseEntity<ExceptionStatus>(status, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
