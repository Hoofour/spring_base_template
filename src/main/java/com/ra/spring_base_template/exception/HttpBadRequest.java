package com.ra.spring_base_template.exception;

public class HttpBadRequest extends RuntimeException {
    public HttpBadRequest(String message) {
        super(message);
    }
}
