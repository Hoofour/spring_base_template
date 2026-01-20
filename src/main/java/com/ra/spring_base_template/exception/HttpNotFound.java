package com.ra.spring_base_template.exception;

public class HttpNotFound extends RuntimeException {
    public HttpNotFound(String message) {
        super(message);
    }
}
