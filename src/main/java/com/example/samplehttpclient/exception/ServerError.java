package com.example.samplehttpclient.exception;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerError extends RuntimeException{
    public ServerError(String message, Throwable cause) {
        super(message, cause);
    }
}
