package com.example.samplehttpclient.exception;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.sql.Timestamp;
import java.util.Date;

public class ExceptionStatus {

    private int statusCode;
    private String message;
    private Date timestamp;


    public ExceptionStatus(int statusCode, String message, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public String getMessage() {
        return message;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    private ExceptionStatus(Builder builder) {
        this.statusCode = builder.statusCode;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int statusCode;
        private String message;
        private Date timestamp;

        public Builder statusCode(int statusCode){
            this.statusCode = statusCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ExceptionStatus build() {
            return new ExceptionStatus(this);
        }
    }



}
