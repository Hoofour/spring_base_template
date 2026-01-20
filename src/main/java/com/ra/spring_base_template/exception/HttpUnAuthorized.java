package com.ra.spring_base_template.exception;

public class HttpUnAuthorized extends RuntimeException {
    public HttpUnAuthorized(String message) {
        super(message);
    }
}
