package com.ra.spring_base_template.exception;

public class HttpForbiden extends RuntimeException {
    public HttpForbiden(String message) {
        super(message);
    }
}
